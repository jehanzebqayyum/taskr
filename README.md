

## Setup H2

### Build & Push Docker Image
* docker build . -t jqayyum/h2
* docker push jqayyum/h2

### Create Kubernetes Pod & Service
* kubectl create -f h2-pod.yml
* kubectl create -f h2-service.yml

Find service url and ports
* minikube service h2-service --url

Verify Service is running
By going to http://<node-ip>:<console-port>




