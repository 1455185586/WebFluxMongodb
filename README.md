# WebFluxMongodb
今天主要是在写用WebFlux模式操作MongoDB数据库，来实现对数据库的增删改查。实现与数据库的连接首先需要
引入Mongodb的依赖，然后是在properties里面配置数据库的连接参数以及地址信息。然后就是编写实体类User，
之后即使编写用于操作MongoDB数据所必须的接口ReactiveMongoRepository。最后要编写增删改查数据的 接口
在这里我把它命名为UserController；跟着《SpringBoot》实战派这本书编写代码的过程算是比较顺利的，但是在运行
的时候无法启动服务器，控制台给出的错误信息是“Field userRepository in com.example.demo.controller.UserController required a bean named 'reactiveMongoTemplate' that could not be found.”
在搜索框里面搜索“reactiveMongoTemplate”这个类确实能搜到东西，也看不出来有什么问题。打开官方给的源码，运行一下
发现能正常运行，于是在官方的代码搜索“'reactiveMongoTemplate' ”类，也搜到了，发现自己写的东西里面的确实少一些
但是复制官方那部分进去却发现是只读属性，最后也没有解决问题；
运行官方的源码往数据库里面写数据发现数据里面最后会多出来一个属性"_class"里面记录了写入的数据属于的实体类的信息，
不知道是MongoDB默认的机制还是在UserController里面写入了这个机制，反正我是没有发现在写数据的时候有跟这一段有关的
代码。
下面是对数据里面的代码中的部分类或者函数的说明：
UserController里面：
produces = MediaType.APPLICATION_STREAM_JSON_VALUE：在这里的媒体类型必须是APPLICATION_STREAM_JSON_VALUE
否则调用端没有办法滚动得到结果，将一直阻塞到数据流结束或者超时
②Duration.ofSeconds(1):代表一秒一秒的返回数据，而不是一下子将数据全部展示出来
③flatMap：返回的是迭代器中的元素
