let tagsApp = new Vue({
    el:'#tagsApp',
    data:{
        tags:[
            {id:1,name:'Spring'},
            {id:1,name:'Spring MVC'},
            {id:1,name:'Spring Boot'},
            {id:1,name:'Spring Cloud'},
            {id:1,name:'Mybatis'}
        ]
    },
    methods:{
        loadTags:function () {
            $.ajax({
                url: '/api-question/v1/tags',
                success: function (json) {
                    tagsApp.tags = json.data;
                }
            })
        }
    },
    created:function () {
        this.loadTags();
    }
});