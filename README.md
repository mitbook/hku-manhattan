```shell script
#规范说明
  1.Map用ConcurrentHashMap
  2.List用CopyOnWriteArrayList
  3.请求类型统一用这种风格@RequestMapping(value = "/selectUserInfo",method = RequestMethod.POST)
  4.分布式锁:redisson
  5.AtomicInteger执行原子类型的i++等操作
```