ParkingManager and use Mvc  
请你阅读我的代码，帮我生成一个parkingManager,初始化parkinglot 三个停车场"The Plaza Park", 9 "City Mall Garage", 12 "Office Tower Parking", 9
停车的时候需要判断车牌号是否正确才可以继续停车服务：车牌号的逻辑是：字母-四个数字，例子AB-1234    
ParkingManager unit test  
您是一名经验丰富的Java软件工程师，正在从事一个关于停车场管理数字化的项目。
您已经创建了aParkingManager类，它管理三个停车场并雇用三个泊车员，每个泊车员都使用特定的泊车策略。
parkingmanager类有以下方法：getAllParkingLots)：返回所有停车场。
park(String plateNumber, String strategy)：请求正确的泊车员根据策略停车，并返回一个包含车牌号码的Ticket对象。
fetch(String ticket)：使用罚单从相应的停车场取车并返回该车。
ParkingManager类管理以下停车场：The Plaza Park（9车位容量），City Mall Garage（12车位容量），Office Tower Parking（9车位容量），ParkingManager使用以下策略的三个停车男孩：标准停车策略，SuperParkingBoy：智能停车策略，SuperParkingBoy：超级智能停车策略，你的任务是为ParkingManager类编写单元测试使用JUnit5在Spring Boot环境。
单元测试应该包括以下场景：初始化测试：验证ParkingManager正确初始化了三个停车场和三个停车男孩。
Get AllParking LotsTest：验证getAllParkingLots（）方法是否返回所有的停车场。
泊车测试：验证Park （String plateNumber, Stringstrategy）方法请求正确的泊车员泊车并返回有效的Ticket。
Fetch Car Test：验证Fetch （String ticket）方法是否使用罚单从相应的停车场获取汽车并返回正确的汽车。
确保所有的测试用例函数名都是在给定格式时使用should_when_given格式编写的  

MVC:  
你是一个高级的MVC架构工程师，正在从事一个关于停车场管理数字化的项目。
现在需要根据SpringMVC的三层架构(controller service repository)，使用RestController来接收前端的请求，根据parkingManager里现有的可能进行拆分成三个restful风格的请求   
默认的映射地址是"/"   
GET："/parkinglots"返回一个基于ParkingManager的getAllParkingLots的一个List数组   
POST："/fetch" 取车操作 传入的是 String plateNumber，根据plateNumber查询出来我的Ticket，验证数据是否存在，根据Ticket在Ticket数组中remove这个Ticket，完成取车操作，再之后返回的是一个car的plateNumber，根据plateNumber设置一个dto进行返回   
POST: "/park" 停车操作，传入需要停车的车牌号和停车策略{String plateNumber, String parkingBoyType}，这里传入的值可以封装成一个requestDto返回的是ticket{String plateNumber, int position, int parkingLot} 在repository中使用parkinglot ArrayList模拟数据库，初始化parkinglot