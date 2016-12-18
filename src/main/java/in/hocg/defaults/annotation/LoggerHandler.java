package in.hocg.defaults.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.UUID;

/**
 * (๑`灬´๑)
 *
 * @author hocgin(admin@hocg.in)
 *         --------------------
 *         Created 16-8-26.
 *
 * @in.hocg.defaults.annotation.Logger 处理器
 */
@Aspect
@Component
public class LoggerHandler {

    ThreadLocal<Long> time=new ThreadLocal<Long>();
    ThreadLocal<String> tag=new ThreadLocal<String>();
    /**
     * 在所有标注@Logger的地方切入
     * @param joinPoint
     */
    @Before("@annotation(in.hocg.defaults.annotation.Logger)")
    public void beforeExec(JoinPoint joinPoint){
        time.set(System.currentTimeMillis());
        tag.set(UUID.randomUUID().toString());
        info(joinPoint);
        MethodSignature ms=(MethodSignature) joinPoint.getSignature();
        Method method=ms.getMethod();
        System.out.println(method.getAnnotation(Logger.class).value()+"标记"+tag.get());
    }

    @After("@annotation(in.hocg.defaults.annotation.Logger)")
    public void afterExec(JoinPoint joinPoint){
        MethodSignature ms=(MethodSignature) joinPoint.getSignature();
        Method method=ms.getMethod();
        System.out.println("Flag："+tag.get()+"，Method："+method.getName()+"，耗时："+(System.currentTimeMillis()-time.get())+"ms");
        System.out.println("--------------------------------------------------");
    }

    @Around("@annotation(in.hocg.defaults.annotation.Logger)")
    public void aroundExec(ProceedingJoinPoint pjp) throws Throwable{
        pjp.proceed();
    }

    private void info(JoinPoint joinPoint){
        System.out.println("--------------------------------------------------");
        System.out.println("King:\t"+joinPoint.getKind());
        System.out.println("Target:\t"+joinPoint.getTarget().toString());
        Object[] os=joinPoint.getArgs();
        System.out.println("Args:");
        for(int i=0;i<os.length;i++){
            System.out.println("\t==>参数["+i+"]:\t"+os[i].toString());
        }
        System.out.println("Signature:\t"+joinPoint.getSignature());
        System.out.println("SourceLocation:\t"+joinPoint.getSourceLocation());
        System.out.println("StaticPart:\t"+joinPoint.getStaticPart());
    }

}
