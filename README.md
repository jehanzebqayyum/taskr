
![Diagram](https://github.com/jehanzebqayyum/taskr/blob/master/taskr-architecture.png)

## Setup H2

#### Build & Push Docker Image
* docker build . -t jqayyum/h2 && docker push jqayyum/h2

#### Create Kubernetes Deployment & Service
* kubectl create -f h2-deployment.yml
* kubectl create -f h2-service.yml

##### Find service url and ports
* minikube service h2-service --url

##### Verify Service is running
By going to h2 web console e.g. http://http://192.168.99.100:31637

Note:
* H2 pod is using persistent volumes although local ones
* H2 service is exposing random ports, in order to demonstrate service discovery


## Setup Apacha Camel (Producer)

Producer picks unprocessed records from h2 db and processes them.

TODO: Send the records/tasks to activemq

#### Package app
* mvn package

#### Build, Tag, & Push Docker Image
* docker build . -t jqayyum/producer && docker push jqayyum/producer

#### Create Kubernetes Pod
* kubectl create -f producer-pod.yml

Note:
* producer is using service discovery using DNS to discover h2-service.

TODO:

* Create service and deployment of producer


##### Useful commands
* view logs stream of a pod
kubectl logs -f producer-pod 

* connect to a pod
kubectl exec -it h2-pod -- /bin/bash

* force delete a pod
kubectl delete pod producer-pod --now --force


Work in progress...
