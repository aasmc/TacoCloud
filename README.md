# Taco Cloud

Educational App based on the book Spring in Action 6-th edition.

### Cassandra Setup

#### Installation
```text
$ docker network create cassandra-net
$ docker run --name my-cassandra \
--network cassandra-net \
-p 9042:9042 \
-d cassandra:latest
```

#### Keyspace setup
```text
$ docker run -it --network cassandra-net --rm cassandra cqlsh my-cassandra

cqlsh> create keyspace tacocloud
... with replication={'class':'SimpleStrategy', 'replication_factor':1}
... and durable_writes=true;
```