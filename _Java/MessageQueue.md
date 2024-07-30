# Message Queue消息队列

Responsible for transferring data from one application to another.

An important component in **distributed systems**. It mainly solves problems such as application coupling, asynchronous messaging异步消息, and traffic peak shaving流量削峰.

Example: ActiveMQ、RabbitMQ、ZeroMQ、Kafka、RocketMQ、MetaMQ

**Two types of Distributed messaging patterns**

- point to point: one message - only one consumer, used messages will be deleted
- publish-subscribe (pub-sub) messaging system. Most of the messaging patterns follow **pub-sub**. 
  - Persist all published records regardless of whether they have been used, can set retention periods.
  - 


## Kafka -  a log

https://www.youtube.com/watch?v=Ch5VhJzaoaI

https://www.youtube.com/watch?v=-DyWhcX3Dpc&list=PLa7VYi0yPIH2PelhRHoFR5iQgflg-y6JA

[Apache Kafka® Architecture: A Complete Guide](https://www.instaclustr.com/blog/apache-kafka-architecture/?_bt=&_bk=&_bm=&_bn=x&_bg=&utm_term=&utm_campaign=&utm_source=adwords&utm_medium=ppc&hsa_acc=1467100120&hsa_cam=20756272281&hsa_grp=&hsa_ad=&hsa_src=x&hsa_tgt=&hsa_kw=&hsa_mt=&hsa_net=adwords&hsa_ver=3&gad_source=1&gclid=EAIaIQobChMIy_DX8MzHhwMVNYRaBR2Lcw-dEAAYAiAAEgKD1fD_BwE)

https://blog.csdn.net/wanglei_storage/article/details/82692413

https://www.cnblogs.com/nhdlb/p/16160545.html

<img src="/Users/xiao/Library/Application Support/typora-user-images/image-20240727120954003.png" alt="image-20240727120954003" style="zoom:50%;" />



### Kafka Architecture

#### Kafka Cluster

##### Broker

Each server node in the kafka cluster.

##### Topic

Each message has a topic - related messages. 

Each topic could be subscribed by **one or more** consumers. (例如订单的record需要仓库，发货系统等消费)

##### Partition

Each topic is split into **multiple partitions**, containing an **ordered**(in the **same** partition) sequence of records. Partitions of the same topic could distribute in **different brokers**.

Each coming record will be **appended to the end**(ordered) of a specific partition file according to the partition policy. (顺序写磁盘，因此效率非常高（经验证，顺序写磁盘效率比随机写内存还要高，这是Kafka高吞吐率的一个很重要的保证）。)

Each partition has multiple **replicas**, which live in different brokers. (leader - using and followers - replicas) 

- Only one works as leader, responsible for reading and writing from clients.
- Other replicas are followers,  just synchronize data from leader. Once the leader failed, one follower will become the leader to continue the work.

##### Record

- Key
- Value
- timestamp

##### Offset

A unique ID to verify each record. Continuously increasing as new messages are written, ensuring the order  to consume.

The offset of each partition is independent.

Must be submitted, otherwise, records maybe consumed repeatedly.

#### Producer

produce messages and send to specific topic, then append to the end of a specific partition.

#### Consumer

consume messages from topic.

#### Zookeeper

- cluster management
- failure detection & recovery
- store ACLs & secrets

### Benefits

- Decoupling  producers and consumers
- **Fault Tolerance**：replicas of partitions
- **Parallelism**: different consumer could consume different partitions of same topic, improve performance.
- **Scalability**: By dividing a topic into multiple partitions, Kafka can handle large volumes of data and provide high throughput. Each partition can be hosted on a different Kafka broker, allowing parallel processing of data across multiple servers.
- **load balance**： if records ⬆️, add more partitions(also avoid single point bottleneck); if consumer ⬆️ / ⬇️, re-distribute records.
- **Order guarantee**: Consume records based on offset, ensuring the order in the same partition.





1. Rotting Oranges  
2. Pacific Atlantic Water Flow  
3. Surrounded Regions  
4. Course Schedule 



1. Kth Largest Element In An Array  
2. Task Scheduler  
3. Design Twitter  
4. Find Median From Data Stream 
5. [Number of Islands](https://neetcode.io/problems/count-number-of-islands)
6. Ma[x Area of Island](https://neetcode.io/problems/max-area-of-island)
7. Clo[ne Graph](https://neetcode.io/problems/clone-graph)
8. Wall[s And Gates](https://neetcode.io/problems/islands-and-treasure)



1. Palindrome Partitioning  
2. Letter Combinations of a Phone Number  
3. N Queens 
4. Kth Largest Element In a Stream  
5. Last Stone Weight  
6. K Closest Points to Origin 



1. Design Add And Search Words Data Structure  
2. Word Search II 
3. Subsets  
4. Combination Sum  
5. Permutations  
6. Subsets II  
7. Combination Sum II  
8. Word Search 
