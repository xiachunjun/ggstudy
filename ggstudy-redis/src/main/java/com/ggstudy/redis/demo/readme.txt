1.所有demo都是使用junit测试的，并且都继承自BaseDemo
2.继承BaseDemo的目的只是@Before @After获取连接，关闭连接，没有其他业务逻辑
3.实际使用中一定注意资源释放的操作