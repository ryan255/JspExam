# JspExam
## 请按如下步骤运行
1. 终端（命令行）进入Exam目录下
2. 输入 mvn tomcat:run
3. 打开浏览器 访问 localhost:8080/Exam/
4. 使用删除功能之前请先点击增加电影自己增加一条记录
5. 上一条是因为原表没能实现级连删除 删除记录要先删除使用其电影名做外键的其它数据表。

> 备注：数据库配置位于 com.hand.conn.JdbcConnection中
