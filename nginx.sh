#!/usr/bin/env bash
# need usa ngrok, default false
# 可以使用 http://wx.web.hocgin.com:80 进行访问
subDomain=wx
port=8080
dir=/home/hocgin/Documents/NutzStore/Nutstore/toolBox/ngrok
echo $dir/bin/ngrok
$dir/bin/ngrok -subdomain $subDomain -proto=http -config=$dir/bin/ngrok.cfg $port
