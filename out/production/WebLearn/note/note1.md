一：Xpath:快速查询xml文件中节点 Demo3.java
    1. / 绝对路径
    2. // 相对路径，选择后代元素 无论层级
    3.* 匹配所有元素
    4.[] 选择条件
    5.属性通过前缀@指定
二：
    1.BBB[@*] 选择任意属性的BBB元素
    2.BBB[not(@*)] 选择没有属性的BBB元素
三：xml创建模拟登陆  Demo4