# Docker-Kubernetes-commands

## Docker commands

1) docker run: Run a new container from an image.
2) docker ps: List all running containers.
3) docker stop: Stop a running container.
4) docker rm: Remove a stopped container.
5) docker images: List all available images.
6) docker rmi: Remove an image.
7) docker pull: Pull an image from a registry.
8) docker exec: Run a command inside a running container.
9) docker attach/detach: Attach/detach to/from a running container.
10) docker run <tagname>: Run a container from an image with a specific tag.
11) docker run -p 80:5000 <appname>: Run a container, mapping port 80 on the host to port 5000 in the container.
12) docker inspect <container-name>: Get detailed information about a container.
13) docker logs <container-name>: View the logs of a container.
14) docker build -t <imagename:tag>: Build an image from a Dockerfile and tag it.
15) docker run --name <container-name> <imagename:tag>: Run a container with a specific name.
16) docker login <pvt-registry-url>: Log in to a private registry.
17) docker run <pvt-repo-url>: Run a container from a private repository.
18) docker compose up
19) docker pause and docker unpause: Pause and unpause all processes in a container.
20) docker rename: Rename a container.
21) docker stats: Display a live stream of container resource usage statistics.
22) docker wait: Block until a container stops, then print its exit code.
23) docker diff: Inspect changes to files or directories on a container's filesystem.
24) docker history: Show the history of an image.
25) docker tag: Create a new tag for an image.

## Docker concepts :

1) Creating a Dockerfile: A Dockerfile is a text file that contains instructions for building an image.
2) Docker Networks:
Bridge: The default network mode, which creates a bridge between the host and container.
None: Disables networking for the container.
Host: Uses the host's network stack.
3) Docker File System: A layered file system that allows for efficient image creation and sharing.
4) Docker Compose: A tool for defining and running multi-container Docker applications.
5) Docker Registry: A repository for storing and managing Docker images.
6) Deploying a Private Docker Registry: Setting up a private registry for storing and managing internal images.
7) Containerization: The process of packaging an application and its dependencies into a container.
8) Kubernetes Components:
etcd: A distributed key-value store for Kubernetes.
Kubelet: An agent that runs on each node, responsible for managing containers.
Container Runtime: The component responsible for running containers, such as Docker.


## Kubectl commands

1) kubectl config view: Show merged kubeconfig settings.
2) kubectl config use-context: Switch between contexts.
3) kubectl rollout history: Check the history of deployments.
4) kubectl rollout undo: Roll back to a previous deployment.
5) kubectl rollout status: Watch rolling update status.
6) kubectl get pods: List all pods in a namespace.
7) kubectl describe pod: Show detailed information about a pod.
8) kubectl logs: Print the logs for a container in a pod.
9) kubectl exec: Execute a command in a container.
10) kubectl expose: Expose a resource as a new Service.
11) kubectl port-forward: Forward traffic from a local port to a pod.
12) kubectl get namespaces: List all namespaces.
13) kubectl create namespace: Create a new namespace.
14) kubectl get nodes: List all nodes.
15) kubectl cordon: Mark a node as unschedulable.
16) kubectl drain: Drain a node in preparation for maintenance.
17) kubectl debug: Create an interactive debugging session within a pod.
18) kubectl top: Display resource usage for nodes or pods.

## JAR / WAR deployment commands :

java -jar <jar-file-name>.jar // run a jar

running jar files with environment :

java -Dspring.profiles.active=dev -jar myapp.jar

1) Deploying a WAR file to Tomcat:

cp myapp.war /usr/local/tomcat/webapps/

2) Deploying a WAR file to a remote Tomcat server :

curl -u admin:password -T myapp.war http://localhost:8080/manager/text/deploy?path=/myapp

3) Deploying a WAR file to a Java-based server (e.g., WildFly, JBoss):

jboss-cli.sh --connect --command="deploy myapp.war



