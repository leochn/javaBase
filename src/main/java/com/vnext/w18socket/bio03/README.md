
BIO同步阻塞模型编程

socketClient：
向socketServer发送请求,请求调用socketServer中的一个方法,并把请求的参数传过去,然后接收socketServer返回过来的结果,并打印出来.

socketServer:
接收socketClient发送过来的请求,并进行解码,然后调用业务方法,并返回结果给socketClient.