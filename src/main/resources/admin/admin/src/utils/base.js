const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootj09hp490/",
            name: "springbootj09hp490",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootj09hp490/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "社区志愿者管理系统"
        } 
    }
}
export default base
