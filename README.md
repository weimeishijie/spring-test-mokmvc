# spring-boot-start-test

## 测试用例编写方式

### 1.Mock测试介绍 

* 定义

        在单元测试过程中，对于某些不容易构造或者不容易获取的对象，用一个虚拟对象来创建以便测试的方法。

* 为什么使用mock测试

        > 避免模块开发间的耦合;</br>
        
        > 轻量、便捷、灵活；

### 2.MockMVC介绍

        基于RESTful风格的SpringMVC单元测试，可以测试完整的SpringMVC流程，即从URL请求到控制处理器，带有试图渲染都可以测试
        
#### 2.1 MockMVC

 * 服务器端SpringMVC测试的主入口点
 
 * 通过MockMVCBuilders构造者的静态方法去建造MockMVCBuilder,MockMvc由MockMVCBuilder构造
 
       常用方法：
       ```
       @Autowired
       private WebApplicationContext wac;
       
       @Before
       public void setUp() throws Exception {
           this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
       }
       
       ```
       
* 核心方法：perform(RequestBuilder rb),执行一个RequestBuilder请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理，该方法的返回值是一个ResultActions。

#### 2.2 MockMvcRequestBuilders

* 用来请求构建Request请求的。

    测试案例：
    ```
    @Test
    public void contextLoads() throws Exception{
    	MvcResult mvcResult = mockMvc.perform(
        		MockMvcRequestBuilders.get("/mock") //构建get方式来调用接口。
        					.contentType(MediaType.APPLICATION_JSON_UTF8) //请求参数的类型
        					.param("hello","world"))
        			.andExpect(MockMvcResultMatchers.status().isOk())
        			.andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
    ```
#### 2.3 ResultActions

* andExpect: 添加ResultMatcher验证规则，验证控制器执行完成后结果是否正确

* andDo: 添加ResultHandler结果处理器，比如调试时打印结果到控制台

* andReturn: 最后返回相应的MvcResult;然后进行自定义验证/惊醒下一步的异步处理

* MockMvcResultMatchers

    * 用来匹配执行完成请求后的**结果验证。
    
    * 结果匹配失败将抛出相应的异常。
    
    * 包含了很多验证API的方法
    
* MockMvcResultHandlers

    * 结果处理器，表示要对结果做点什么事情
    
    * 比如此处使用MockMvcResultHandlers.print()输出整个相应结果信息
    
#### 注意：

    * spring-boot-start-test 包版本在 2.1.6.RELEASE 以下注解@RunWith运行正常，超过此版本将会出现运行需要额外配置
    


[README.md编写参考文献](https://github.com/guodongxiaren/README/blob/master/README.md)  

       