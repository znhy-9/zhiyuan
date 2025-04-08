<template>
	<view class="content">
		<view :style='{"width":"100%","padding":"20rpx","position":"relative","background":"url(http://codegen.caihongy.cn/20241026/8fe1d70afdba44cf8f73d5087d7a62bc.jpg) no-repeat center top / 100% auto,#fff","height":"100%"}'>
			<view v-if="user&&user.id" :style='{"padding":"48rpx 24rpx","boxShadow":"2rpx 0px 0px 0px #DCD0C050, 0px 2rpx 0px 0px #B1938B50, -2rpx 0px 0px 0px #98737350, 0px 0px 0px 2rpx #DA635D50","margin":"0 0 20rpx 0","borderRadius":"0 60rpx 0 0","background":"rgba(255,255,255,.8)","display":"flex","width":"100%","position":"relative","height":"auto"}' @tap="onPageTap('../user-info/user-info')" class="header" v-bind:class="{'status':isH5Plus}">
				<view :style='{"width":"100%","flexWrap":"wrap","flexDirection":"column","display":"block","height":"auto"}' v-if="tableName=='zhiyuanzhe'" class="userinfo">
					<image :style='{"width":"108rpx","padding":"0","margin":"0 20rpx 0 0","borderRadius":"100%","float":"left","height":"108rpx"}' :src="user.touxiang?baseUrl+user.touxiang:require('../../static/gen/upload.png')"></image>
					<view :style='{"width":"auto","float":"left","flexDirection":"column","justifyContent":"center","display":"inline-block"}' class="info">
						<view :style='{"width":"100%","lineHeight":"48rpx","fontSize":"28rpx","color":"#333"}'>{{user.zhiyuanzhezhanghao}}<text v-if="user.vip&& user.vip=='是'">(VIP)</text></view>
					</view>
					
					<view :style='{"width":"100%","clear":"both","margin":"140rpx 0 0","flexWrap":"wrap","display":"flex"}' class="info">
						<view :style='{"width":"auto","margin":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","display":"flex"}'>
							<span :style='{"color":"#333","whiteSpace":"nowrap"}'>手机号：</span>
							<span :style='{"color":"#333"}'>{{user.shoujihao}}</span>
						</view>
					</view>
				</view>
				<view :style='{"padding":"0 0 0 20rpx","alignItems":"center","top":"40rpx","flexDirection":"column","display":"flex","width":"84rpx","position":"absolute","right":"40rpx","justifyContent":"center","height":"auto"}' class="setting">
					<text class="icon iconfont icon-qita6" :style='{"border":"0","width":"64rpx","lineHeight":"64rpx","fontSize":"64rpx","color":"#333","borderRadius":"0"}'></text>
					<text :style='{"color":"#333","lineHeight":"2","fontSize":"28rpx"}'>设置</text>
				</view>
			</view>
			
			<view v-else :style='{"padding":"48rpx 24rpx","boxShadow":"2rpx 0px 0px 0px #DCD0C050, 0px 2rpx 0px 0px #B1938B50, -2rpx 0px 0px 0px #98737350, 0px 0px 0px 2rpx #DA635D50","margin":"0 0 20rpx 0","borderRadius":"0 60rpx 0 0","background":"rgba(255,255,255,.8)","display":"flex","width":"100%","position":"relative","height":"auto"}' @tap="loginClick" class="header" v-bind:class="{'status':isH5Plus}">
				<view :style='{"alignItems":"center","color":"#666","display":"flex","width":"100%","fontSize":"36rpx","justifyContent":"center","height":"300rpx"}'>登录/注册</view>
			</view>
			
			<view :style='{"width":"100%","background":"#fff","height":"auto"}' class="list">
				
				<view :style='{"width":"100%","height":"auto"}'>
					<view :style='{"margin":"40rpx 0","color":"#fff","borderRadius":"0 60rpx 0 0","textAlign":"center","background":"url(http://codegen.caihongy.cn/20241025/2f5aea076ec345abb2ef9e6289f2c5a7.png) no-repeat left center / auto 100%,#ef7061","width":"100%","lineHeight":"80rpx","fontSize":"36rpx"}'>
						<view :style='{"color":"#fff","fontSize":"36rpx","lineHeight":"88rpx"}'>我的服务</view>
					</view>
					<view class="me-menu-view">
						<block v-for="item in menuList" v-bind:key="item.roleName">
							<block v-if="role==item.roleName" v-bind:key="menu.menu" v-for="(menu,index) in item.backMenu">
								<block v-bind:key="child.tableName" v-for=" (child,sort) in menu.child">
									<view class="me-menu-item" v-if="child.tableName!='orders/已发货' && child.tableName!='orders/已退款' &&child.tableName!='orders/已取消' && child.tableName!='orders/未支付' && child.tableName!='orders/已支付' && child.tableName!='orders/已完成' && child.tableName!='exampaper' && child.tableName!='examquestion'&& child.tableName!='hasTranslate' " @tap="onPageTap('../'+child.tableName+'/list?userid='+user.id+'&menuJump='+child.menuJump)" hover-class="hover">
										<view class="me-menu-icon" :class="child.appFrontIcon" :style="{'color': meMenuColor[index]}"></view>
										<view class="text">{{child.menu}}</view>
										<view class="icon iconfont icon-jinru"></view>
									</view>
								</block>
							</block>
						</block>


						<view v-if="user&&user.id" @tap="passwordShow()" class="me-menu-item" hover-class="hover">
							<view class="cuIcon-lock me-menu-icon" :style="{'color': meMenuColor[6]}"></view>
							<view class="text">修改密码</view>
							<view class="icon iconfont icon-jinru"></view>
						</view>
					</view>
				</view>
			</view>
			
			<!-- 推荐 -->
			<view style="width: 100%;height: 80px"></view>
		</view>
		<uni-popup class="popup-content" ref="passwordPopup" type="bottom">
			<view class="passwordForm">
				<view class="passwordInput">
					<input type="password" v-model="passwordForm.mima" placeholder="原密码" />
				</view>
				<view class="passwordInput">
					<input type="password" v-model="passwordForm.newmima" placeholder="新密码" />
				</view>
				<view class="passwordInput">
					<input type="password" v-model="passwordForm.newmima1" placeholder="确认密码" />
				</view>
				<view class="passwordBtnView">
					<button class="passwordBtn" @click="updatePassword">更新</button>
				</view>
			</view>
		</uni-popup>
	</view>
</template>
<script>
	import menu from '@/utils/menu'
	export default {
		data() {
			return {
				isH5Plus: true,
				user: {},
				tableName:'',
				role: '',
				menuList: [],
				iconArr: [
					'cuIcon-same',
					'cuIcon-deliver',
					'cuIcon-evaluate',
					'cuIcon-shop',
					'cuIcon-ticket',
					'cuIcon-cascades',
					'cuIcon-discover',
					'cuIcon-question',
					'cuIcon-pic',
					'cuIcon-filter',
					'cuIcon-footprint',
					'cuIcon-pulldown',
					'cuIcon-pullup',
					'cuIcon-moreandroid',
					'cuIcon-refund',
					'cuIcon-qrcode',
					'cuIcon-remind',
					'cuIcon-profile',
					'cuIcon-home',
					'cuIcon-message',
					'cuIcon-link',
					'cuIcon-lock',
					'cuIcon-unlock',
					'cuIcon-vip',
					'cuIcon-weibo',
					'cuIcon-activity',
					'cuIcon-friendadd',
					'cuIcon-friendfamous',
					'cuIcon-friend',
					'cuIcon-goods',
					'cuIcon-selection'
				],
				passwordForm: {
					mima: '',
					newmima: '',
					newmima1: '',
				},
				meMenuColor: '#409eff,#67c23a,#909399,#e6a23c,#f56c6c,#356c6c,#351c6c,#f093a9,#a7c23a,#104eff,#10441f,#a21233,#503319'.split(',')
			};
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onLoad(){
			let menus = menu.list();
			this.menuList = menus;
			this.meMenuColor = this.meMenuColor.sort(()=> {
				return (0.5-Math.random());
			});
		},
		async onShow(){
            uni.removeStorageSync("useridTag");
			this.role = uni.getStorageSync("appRole");
			await this.getSession()
			this.getThumbsup()
			this.getStoreup()
			this.tableName = uni.getStorageSync("nowTable");
			let menus = menu.list();
			this.menuList = menus;
			this.$forceUpdate()
		},
		methods: {
			async getSession(){
				let table = uni.getStorageSync("nowTable");
				let res = await this.$api.session(table);
				this.user = res.data;
				this.$forceUpdate()
			},
			async getThumbsup(){
				if(!this.user||!this.user.id){
					return false
				}
				let res = await this.$api.page('storeup',{userid: this.user.id,type: 21})
				this.user.thumbsnum = Number(res.data.total)
				this.$forceUpdate()
			},
			async getStoreup(){
				if(!this.user||!this.user.id){
					return false
				}
				let res = await this.$api.page('storeup',{userid: this.user.id,type: 1})
				this.user.storenum = Number(res.data.total)
				this.$forceUpdate()
			},
			loginClick(){
				uni.navigateTo({
					url: '../login/login'
				});
			},
			onPageTap(url) {
                uni.setStorageSync("useridTag",1);
				uni.navigateTo({
					url: url,
					fail: function() {
						uni.switchTab({
							url: url
						});
					}
				});
			},
			hasTranslate(){
				for(let x in this.menuList){
					if(this.menuList[x].roleName == this.role){
						for(let i in this.menuList[x].backMenu){
							if(this.menuList[x].backMenu[i].child.length) {
								for(let j in this.menuList[x].backMenu[i].child) {
									if(this.menuList[x].backMenu[i].child[j].tableName=='hasTranslate'){
										return true
									}
								}
							}
						}
					}
				}
				return false
			},
			
			preHttp(str) {
			    return str && str.substr(0,4)=='http';
			},
			recommendDetail(id) {
				uni.navigateTo({
					url: `../${this.recommendTable}/detail?id=${id}`,
					fail: function() {
						uni.switchTab({
							url: `../${this.recommendTable}/detail?id=${id}`
						});
					}
				});
			},
			passwordShow() {
				this.passwordForm = {
					mima: '',
					newmima: '',
					newmima1: '',
				}
				this.$forceUpdate()
				this.$refs.passwordPopup.open()
			},
			async updatePassword() {
				if (this.passwordForm.mima == ''){
					this.$utils.msg('原密码不能为空')
					return false
				}
				if (this.passwordForm.newmima == ''){
					this.$utils.msg('新密码不能为空')
					return false
				}
				if (this.passwordForm.newmima1 == ''){
					this.$utils.msg('确认密码不能为空')
					return false
				}
				let password = ''
				if (this.user.mima) {
					password = this.user.mima;
				} else if (this.user.password) {
					password = this.user.password;
				}
				if (this.tableName == 'zhiyuanzhe') {
				}
				let newpassword = this.passwordForm.mima
				if(password != newpassword){
					this.$utils.msg('原密码不正确')
					return false
				}
				if (this.passwordForm.newmima != this.passwordForm.newmima1){
					this.$utils.msg('两次密码不一致')
					return false
				}
				if (this.passwordForm.mima == this.passwordForm.newmima){
					this.$utils.msg('新密码与原密码相同！')
					return false
				}
				this.user.password = this.passwordForm.newmima
				this.user.mima = this.passwordForm.newmima
				await this.$api.update(this.tableName,this.user)
				this.$utils.msg('修改密码成功,下次登录系统生效')
				this.$refs.passwordPopup.close()
				this.getSession()
			},
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		height: calc(100vh - 94px);
		box-sizing: border-box;
	}
	.passwordForm {
		width: 100%;
		padding: 10px 20px 60px;
		background: #fff;
	
		.passwordInput {
			background: #eee;
			margin: 0 0 10px;
			padding: 0 10px;
	
			input {
				height: 36px;
				line-height: 36px;
				font-size: 14px;
			}
		}
	
		.passwordBtnView {
			width: 100%;
			display: flex;
			align-items: center;
			justify-content: center;
			padding: 10px 0;
	
			.passwordBtn {
				padding: 0 20px;
				width: auto;
				height: 20px;
				line-height: 20px;
				font-size: 14px;
				color: #fff;
				background: #007aff;
				border: none;
				border-radius: 5px;
	
			}
		}
	}
	.me-menu-view {
		padding: 0;
		align-content: flex-start;
		display: flex;
		width: 100%;
		align-items: flex-start;
		flex-wrap: wrap;
		height: auto;
		.me-menu-item {
			padding: 20rpx 10rpx 10rpx;
			margin: 0 20rpx 40rpx;
			display: flex;
			border-color: #ccc;
			border-radius: 0 60rpx 0 0;
			box-shadow: 2rpx 0px 0px 0px #DCD0C050, 0px 2rpx 0px 0px #B1938B50, -2rpx 0px 0px 0px #98737350, 0px 0px 0px 2rpx #DA635D50;
			flex-direction: column;
			background: #ef706110;
			width: calc(50% - 40rpx);
			border-width: 0 0 0px;
			align-items: center;
			position: relative;
			border-style: solid;
			height: auto;
			.me-menu-icon {
				color: rgba(0, 186, 189, 1);
				font-size: 60rpx;
				line-height: 1;
			}
			.text {
				padding: 0 20rpx;
				color: #333;
				flex: 1;
				width: 100%;
				font-size: 28rpx;
				line-height: 60rpx;
				text-align: center;
			}
			.icon {
				color: #999;
				top: 40%;
				width: 28rpx;
				font-size: 28rpx;
				line-height: 28rpx;
				position: absolute;
				right: 10rpx;
			}
		}
	}
</style>
