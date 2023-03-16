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
  model: gpt_4 #支持不同的模型，项目中有枚举类说明每种的特点com.xdz.chatgpt.config.enums.ModelEnum
  max-tokens: 500 #指定生成文本的长度，太小影响返回的结果，太大相对比较耗费资源（收费方式于此有关）
  temperature: 0.5 #用于控制生成文本的创造性和多样性的参数，值越大生成的文本越不可预测，值越小生成的文本越保守和可预测
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
        System.out.println(chatGptService.sendMessage("mysql的事务"));
    }
}
```
<a name="YlqWD"></a>
## 5、测试结果
```text
\n\nMySQL的事务是一组SQL语句，它们被视为一个单独的操作，要么全部执行成功，要么全部执行失败，它们被称为原子操作。MySQL的事务可以帮助确保数据库中的数据完整性，并在并发访问下提供一致性。\n\n在MySQL中，一个事务可以包含多个SQL语句，这些语句被当做一个整体进行操作。如果其中一个语句执行失败，整个事务都会被回滚，以确保数据的一致性。\n\nMySQL支持四种隔离级别：读未提交（read uncommitted）、读已提交（read committed）、可重复读（repeatable read）和串行化（serializable）。这些隔离级别可以通过设置事务的隔离级别来控制并发事务的访问。\n\nMySQL的事务可以使用以下命令来控制：\n\n1. BEGIN或START TRANSACTION：开始一个新的事务。\n\n2. COMMIT：提交事务，将所有修改保存到数据库。\n\n3. ROLLBACK：回滚事务，取消所有修改。\n\n4. SAVEPOINT：设置一个保存点，可以在事务中回滚到该点。\n\n5. ROLLBACK TO SAVEPOINT：回滚到一个保存点。\n\n6. RELEASE SAVEPOINT：删除一个保存点。\n\nMySQL的事务可以在存储引擎的支持下进行。InnoDB存储引擎是MySQL默认的事务存储引擎，它提供了高级的事务处理功能。其他存储引擎，如MyISAM，不支持事务处理。
```
结果相对可能不太友好，之后会持续改进，但此项目使用的是官方的api，不用担心不能用的问题
# 2、联系方式
如果有更多的需求或者相关的意见或建议，请联系：<br />qq: 3337466712
