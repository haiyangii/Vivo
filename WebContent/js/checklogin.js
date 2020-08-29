let login= new Vue({
	el:"#login_info",
	data:{
		onlogin:false,
		loginName:"匿名",
		loginId:"",
		cartCount: 0,
		carts:[]
	},
	
	mounted: function(){
		/*axios.get("member",{params:{op:"info"}}).then(result => {
			if(result.data.code == 200){//说明已经登录
				this.onlogin = true;
				this.loginName = result.data.data.nickName;
				this.loginId = result.data.data.mno;
			}else{
				this.onlogin = false;
			}
		})*/
		
		axios.all([checkLogin(),getCartInfo()]).then(axios.spread((fn1,fn2)=>{
			if(fn1.data.code == 200){
				this.onlogin = true;
				this.loginName = fn1.data.data.uname;
				this.loginId = fn1.data.data.uid;
			}else{
				this.onlogin = false;
			}
			
			if(fn2.data.code == 200){
				this.cartCount = fn2.data.data.length;
				this.carts = fn2.data.data;
			}else{
				this.cartCount = 0;
			}
		}))
	}
})
function checkLogin(){
	return axios.get("user",{params:{op:"info"}});
}

function getCartInfo(){
	return axios.get("cart",{params:{op:"info"}});
}
