<a name="zveEu"></a>
# 1、项目背景
基于当前chatGPT的势头，为了方便广大开发者接入官方API而提供的基于springboot的自动配置依赖项目
<a name="fcb87eb5"></a>
# 2、接入方式
<a name="8b17b851"></a>
## 1、添加maven依赖
```xml
<dependency>
  <groupId>com.xdz</groupId>
  <artifactId>chatgpt-spring-boot-starter</artifactId>
  <version>1.0.0</version>
</dependency>
```
<a name="neof2"></a>
## 2、添加配置
```yaml
chatgpt:
  api-key: #官网申请的apiKey
  model: davinciCodex #支持不同的模块，项目中有枚举类说明每种的特点com.xdz.chatgpt.config.enums.ModelEnum
  max-tokens: 500 #指定生成文本的长度，太小影响返回的结果，太大相对比较耗费资源（收费方式于此有关）
  temperature: 0.5 #用于控制生成文本的创造性和多样性的参数，值越大生成的文本越不可预测，值越小生成的文本越保守和可预测
  stop: . #用于控制生成文本的终止符
```
上述配置除了api-key，其余都有默认值，入手比较简单
<a name="f16Gc"></a>
## 3、启动类添加开启注解
添加此注解用于开启chatgpt相关自动注入
```java
@EnableChatGpt
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```
<a name="INKc9"></a>
## 4、注入操作Bean
```java
@SpringBootTest
class ChatGptTests {
    @Resource
    private ChatGptService chatGptService;

    @Test
    void test() {
        System.out.println(chatGptService.sendMessage("Java实现快速排序示例"));
    }
}
```
<a name="YlqWD"></a>
# 2、联系方式
如果有更多的需求或者相关的意见或建议，请联系：<br />qq: 3337466712
