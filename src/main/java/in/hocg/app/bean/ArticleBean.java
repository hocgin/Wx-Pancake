package in.hocg.app.bean;

import in.hocg.defaults.base.bean.SoftDeletedTable;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by hocgin on 16-12-18.
 * 文章表
 */
@Entity
@Table(name = "t_articles")
@DynamicUpdate//动态更新
@DynamicInsert//动态插入
public class ArticleBean extends SoftDeletedTable {
	/**
	 * 类型 [Url]
	 */
	@Column(name = "type")
	private String type;
	/**
	 * 标题
	 */
	@Column(name = "title")
	private String title;
	/**
	 * 标签
	 */
	@Column(name = "tags")
	private String tags;
	/**
	 * 概要
	 */
	@Column(name = "describes")
	private String describes;
	/**
	 * 图片
	 */
	@Column(name = "picture")
	private String picture;
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTags() {
		return tags;
	}
	
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	public String getDescribes() {
		return describes;
	}
	
	public void setDescribes(String describes) {
		this.describes = describes;
	}
	
	public String getPicture() {
		return picture;
	}
	
	public void setPicture(String picture) {
		this.picture = picture;
	}
}
