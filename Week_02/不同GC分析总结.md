# 不同GC分析总结



串行 GC

java -Xmx1g -Xms1g -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseSerialGC GCLogAnalysis

| 内存大小 | 生成对象次数 | youngGC次数 | youngGC总耗时（s） | youngGC平均耗时 | FullGC次数 | FullGC总耗时（s） |
| -------- | ------------ | ----------- | ------------------ | --------------- | ---------- | ----------------- |
| 512m     | 6779         | 13          | 0.38               | 0.29            | 0          | 0                 |
| 1g       | 5174         | 5           | 0.17               | 0.034           | 0          | 0                 |
| 2g       | 4154         | 2           | 0.12               | 0.6             | 0          | 0                 |
| 4g       | 3930         | 2           | 0.12               | 0.6             | 0          | 0                 |



 并行 GC

java -Xmx1g -Xms1g -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseParallelGC GCLogAnalysis







CMS GC

java -Xmx1g -Xms1g -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseConcMarkSweepGC GCLogAnalysis







G1  GC 

java -Xmx1g -Xms1g -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseG1GC GCLogAnalysis





分析：

不同GC的类型区分的区域大小不一样，内存越大，youngGC时间越长，越不会触发fullGC，可以处理的对象数量并不一定会更大。所以需要根据具体的业务系统在不同压力下进行测试，进行JVM参数调优。

















