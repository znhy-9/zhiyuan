<template>
<view class="content">
	<view :style='{"width":"100%","padding":"40rpx 0 0","position":"relative","background":"#f7f7f7","height":"100%"}'>
		<form :style='{"width":"100%","padding":"24rpx","background":"none","display":"block","height":"auto"}' class="app-update-pv">
			<view :style='{"padding":"12rpx 0","boxShadow":"2rpx 0px 0px 0px #DCD0C050, 0px 2rpx 0px 0px #B1938B50, -2rpx 0px 0px 0px #98737350, 0px 0px 0px 2rpx #DA635D50","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0 60rpx 0 0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">礼品名称</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.lipinmingcheng" v-model="ruleForm.lipinmingcheng" placeholder="礼品名称"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"2rpx 0px 0px 0px #DCD0C050, 0px 2rpx 0px 0px #B1938B50, -2rpx 0px 0px 0px #98737350, 0px 0px 0px 2rpx #DA635D50","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0 60rpx 0 0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="" @tap="lipinfengmianTap">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">礼品封面</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-if="ruleForm.lipinfengmian" :src="baseUrl+ruleForm.lipinfengmian.split(',')[0]" mode="aspectFill"></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"2rpx 0px 0px 0px #DCD0C050, 0px 2rpx 0px 0px #B1938B50, -2rpx 0px 0px 0px #98737350, 0px 0px 0px 2rpx #DA635D50","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0 60rpx 0 0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">兑换数量</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.lipinshuliang" v-model.number="ruleForm.lipinshuliang" placeholder="兑换数量" type="number"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"2rpx 0px 0px 0px #DCD0C050, 0px 2rpx 0px 0px #B1938B50, -2rpx 0px 0px 0px #98737350, 0px 0px 0px 2rpx #DA635D50","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0 60rpx 0 0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">所需积分</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.suoxujifen" v-model.number="ruleForm.suoxujifen" placeholder="所需积分" type="digit"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"2rpx 0px 0px 0px #DCD0C050, 0px 2rpx 0px 0px #B1938B50, -2rpx 0px 0px 0px #98737350, 0px 0px 0px 2rpx #DA635D50","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0 60rpx 0 0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">总积分</view>
				<view :style='{"padding":"0px 24rpx","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)","flex":"1"}' class="right-input">
					{{zhiyuanjifen}}
				</view>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"2rpx 0px 0px 0px #DCD0C050, 0px 2rpx 0px 0px #B1938B50, -2rpx 0px 0px 0px #98737350, 0px 0px 0px 2rpx #DA635D50","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0 60rpx 0 0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">志愿者账号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.zhiyuanzhezhanghao" v-model="ruleForm.zhiyuanzhezhanghao" placeholder="志愿者账号"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"2rpx 0px 0px 0px #DCD0C050, 0px 2rpx 0px 0px #B1938B50, -2rpx 0px 0px 0px #98737350, 0px 0px 0px 2rpx #DA635D50","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0 60rpx 0 0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">志愿者姓名</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.zhiyuanzhexingming" v-model="ruleForm.zhiyuanzhexingming" placeholder="志愿者姓名"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"2rpx 0px 0px 0px #DCD0C050, 0px 2rpx 0px 0px #B1938B50, -2rpx 0px 0px 0px #98737350, 0px 0px 0px 2rpx #DA635D50","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0 60rpx 0 0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">剩余积分</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.shengyujifen" v-model.number="ruleForm.shengyujifen" placeholder="剩余积分" type="digit"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"2rpx 0px 0px 0px #DCD0C050, 0px 2rpx 0px 0px #B1938B50, -2rpx 0px 0px 0px #98737350, 0px 0px 0px 2rpx #DA635D50","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0 60rpx 0 0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">兑换时间</view>
				<input :disabled="ro.duihuanshijian" :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' v-model="ruleForm.duihuanshijian" placeholder="兑换时间" @tap="toggleTab('duihuanshijian')"></input>
			</view>
           
			
			<view :style='{"width":"100%","justifyContent":"center","display":"flex","height":"auto"}' class="btn" >
				<button :style='{"border":"0","padding":"0px","margin":"0 40rpx 0 0","color":"rgb(255, 255, 255)","borderRadius":"0 60rpx 0 0","background":"#ef7061","width":"250rpx","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' @tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

		<w-picker  mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="duihuanshijianConfirm" ref="duihuanshijian" themeColor="#333333"></w-picker>
	</view>
</view>
</template>

<script>
	import wPicker from "@/components/w-picker/w-picker.vue";
	import xiaEditor from '@/components/xia-editor/xia-editor';
	import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
				cross:'',
				ruleForm: {
				lipinmingcheng: '',
				lipinfengmian: '',
				lipinshuliang: '',
				suoxujifen: '',
				zhiyuanjifen: '',
				zhiyuanzhezhanghao: '',
				zhiyuanzhexingming: '',
				shengyujifen: '',
				duihuanshijian: '',
				crossuserid: '',
				crossrefid: '',
				},
				// 登录用户信息
				user: {},
				ro:{
				   lipinmingcheng : false,
				   lipinfengmian : false,
				   lipinshuliang : false,
				   suoxujifen : false,
				   zhiyuanjifen : false,
				   zhiyuanzhezhanghao : false,
				   zhiyuanzhexingming : false,
				   shengyujifen : false,
				   duihuanshijian : false,
				   crossuserid : false,
				   crossrefid : false,
				},
				virtualPay: false,
			}
		},
		components: {
			wPicker,
			xiaEditor,
			multipleSelect,
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},


			zhiyuanjifen:{
			get: function () {
				return 1*this.ruleForm.lipinshuliang*this.ruleForm.suoxujifen
			}
			},

		},
		async onLoad(options) {
			if(options.virtualPay){
				this.virtualPay = true
			}
			this.ruleForm.duihuanshijian =  this.$utils.getCurDateTime();
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取
			this.ruleForm.zhiyuanzhezhanghao = this.user.zhiyuanzhezhanghao
			this.ro.zhiyuanzhezhanghao = true;
			this.ruleForm.zhiyuanzhexingming = this.user.zhiyuanzhexingming
			this.ro.zhiyuanzhexingming = true;
			this.ruleForm.shengyujifen = this.user.zhiyuanjifen
			this.ro.shengyujifen = true;



			// 如果有登录，获取登录后保存的userid
			this.ruleForm.userid = uni.getStorageSync("appUserid")
			if (options.refid) {
				// 如果上一级页面传递了refid，获取改refid数据信息
				this.ruleForm.refid = Number(options.refid);
				this.ruleForm.nickname = uni.getStorageSync("nickname");
			}
			// 如果是更新操作
			if (options.id) {
				this.ruleForm.id = options.id;
				// 获取信息
				res = await this.$api.info(`jifenduihuan`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
					if(o=='lipinmingcheng'){
						this.ruleForm.lipinmingcheng = obj[o];
						this.ro.lipinmingcheng = true;
						continue;
					}
					if(o=='lipinfengmian'){
						this.ruleForm.lipinfengmian = obj[o].split(",")[0];
						this.ro.lipinfengmian = true;
						continue;
					}
					if(o=='lipinshuliang'){
						this.ruleForm.lipinshuliang = obj[o];
						this.ro.lipinshuliang = true;
						continue;
					}
					if(o=='suoxujifen'){
						this.ruleForm.suoxujifen = obj[o];
						this.ro.suoxujifen = true;
						continue;
					}
					if(o=='zhiyuanjifen'){
						this.ruleForm.zhiyuanjifen = obj[o];
						this.ro.zhiyuanjifen = true;
						continue;
					}
					if(o=='zhiyuanzhezhanghao'){
						this.ruleForm.zhiyuanzhezhanghao = obj[o];
						this.ro.zhiyuanzhezhanghao = true;
						continue;
					}
					if(o=='zhiyuanzhexingming'){
						this.ruleForm.zhiyuanzhexingming = obj[o];
						this.ro.zhiyuanzhexingming = true;
						continue;
					}
					if(o=='shengyujifen'){
						this.ruleForm.shengyujifen = obj[o];
						this.ro.shengyujifen = true;
						continue;
					}
					if(o=='duihuanshijian'){
						this.ruleForm.duihuanshijian = obj[o];
						this.ro.duihuanshijian = true;
						continue;
					}
					if(o=='crossuserid'){
						this.ruleForm.crossuserid = obj[o];
						this.ro.crossuserid = true;
						continue;
					}
					if(o=='crossrefid'){
						this.ruleForm.crossrefid = obj[o];
						this.ro.crossrefid = true;
						continue;
					}
				}
			this.ruleForm.lipinshuliang = 0;
			this.ro.lipinshuliang = false;
			}
			this.styleChange()
			this.$forceUpdate()
			if (uni.getStorageSync('raffleType') && uni.getStorageSync('raffleType') != null) {
				uni.removeStorageSync('raffleType')
				setTimeout(() => {
					this.onSubmitTap()
				}, 300)
			}
		},
		methods: {
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.app-update-pv . .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.addUpdateForm.input.content.backgroundColor
					// })
				})
			},

			// 多级联动参数


			// 日长控件选择日期时间
			duihuanshijianConfirm(val) {
				console.log(val)
				this.ruleForm.duihuanshijian = val.result;
				this.$forceUpdate();
			},


			lipinfengmianTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.lipinfengmian = 'upload/' + res.file;
					_this.$forceUpdate();
					_this.$nextTick(()=>{
						_this.styleChange()
					})
				});
			},

			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {
				let that = this
				this.ruleForm.zhiyuanjifen = this.zhiyuanjifen
				if(Number(this.ruleForm.zhiyuanjifen)>Number(this.ruleForm.shengyujifen)){
					this.$utils.msg(`总积分不能超过剩余积分`);
					return
				}
				//跨表计算判断
				if((parseFloat(this.user.zhiyuanjifen) - parseFloat(this.ruleForm.zhiyuanjifen)) < 0){
					this.$utils.msg(`您的总积分不足`);
					return false
				}
				var obj;
				obj = uni.getStorageSync('crossObj');
				var table = uni.getStorageSync('crossTable');
				//obj.lipinshuliang = obj.lipinshuliang - this.ruleForm.lipinshuliang
				if((parseFloat(obj.lipinshuliang) - parseFloat(this.ruleForm.lipinshuliang))<0){
					this.$utils.msg("兑换数量不足");
					return
				}
				if(this.ruleForm.lipinshuliang<=0){
					this.$utils.msg("兑换数量不能为0");
					return
				}
				if(this.ruleForm.lipinshuliang&&(!this.$validate.isIntNumer(this.ruleForm.lipinshuliang))){
					this.$utils.msg(`兑换数量应输入整数`);
					return
				}
				if(this.ruleForm.suoxujifen&&(!this.$validate.isNumber(this.ruleForm.suoxujifen))){
					this.$utils.msg(`所需积分应输入数字`);
					return
				}
				if(this.ruleForm.zhiyuanjifen&&(!this.$validate.isNumber(this.ruleForm.zhiyuanjifen))){
					this.$utils.msg(`总积分应输入数字`);
					return
				}
				if(this.ruleForm.shengyujifen&&(!this.$validate.isNumber(this.ruleForm.shengyujifen))){
					this.$utils.msg(`剩余积分应输入数字`);
					return
				}
				//更新跨表属性
				var crossuserid;
				var crossrefid;
				var crossoptnum;
				if(this.cross){
					var statusColumnName = uni.getStorageSync('statusColumnName');
					var statusColumnValue = uni.getStorageSync('statusColumnValue');
					if(statusColumnName!='') {
						if(!obj) {
							obj = uni.getStorageSync('crossObj');
						}
						if(!statusColumnName.startsWith("[")) {
							for (var o in obj){
								if(o==statusColumnName){
									obj[o] = statusColumnValue;
								}

							}
							var table = uni.getStorageSync('crossTable');
							await this.$api.update(`${table}`, obj);
						} else {
							   crossuserid=Number(uni.getStorageSync('appUserid'));
							   crossrefid=obj['id'];
							   crossoptnum=uni.getStorageSync('statusColumnName');
							   crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
						}
					}
				}
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid=crossuserid;
					this.ruleForm.crossrefid=crossrefid;
					let params = {
						page: 1,
						limit:10,
						crossuserid:crossuserid,
						crossrefid:crossrefid,
					}
					let res = await this.$api.list(`jifenduihuan`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
						uni.removeStorageSync('crossCleanType');
						return false;
					} else {
				//跨表计算
						if(!obj) {
							obj = uni.getStorageSync('crossObj');
						}
						var table = uni.getStorageSync('crossTable');
						obj.lipinshuliang = parseFloat(obj.lipinshuliang) - parseFloat(this.ruleForm.lipinshuliang)
						await this.$api.update(`${table}`, obj);
						let oet = {}
						if(this.ruleForm.id){
							await this.$api.update(`jifenduihuan`, this.ruleForm);
						}else{
							oet = await this.$api.add(`jifenduihuan`, this.ruleForm);
						 if(this.user.zhiyuanjifen>=0) {
							 this.user.zhiyuanjifen = parseFloat(this.user.zhiyuanjifen) - parseFloat(this.ruleForm.zhiyuanjifen)
							 await this.$api.update(uni.getStorageSync("nowTable"), this.user);
						 }
						}
						if(this.cross){
							uni.setStorageSync('crossCleanType',true);
						}
						this.$utils.msgBack('提交成功');
					}
				} else {
				//跨表计算
					if(!obj) {
						obj = uni.getStorageSync('crossObj');
					}
					var table = uni.getStorageSync('crossTable');
					obj.lipinshuliang = obj.lipinshuliang - this.ruleForm.lipinshuliang
					await this.$api.update(`${table}`, obj);
					let oet = {}
					if(this.ruleForm.id){
						await this.$api.update(`jifenduihuan`, this.ruleForm);
					}else{
						oet = await this.$api.add(`jifenduihuan`, this.ruleForm);
						 if(this.user.zhiyuanjifen>=0) {
							 this.user.zhiyuanjifen = parseFloat(this.user.zhiyuanjifen) - parseFloat(this.ruleForm.zhiyuanjifen)
							 await this.$api.update(uni.getStorageSync("nowTable"), this.user);
						 }
					}
					if(this.cross){
						uni.setStorageSync('crossCleanType',true);
					}
					this.$utils.msgBack('提交成功');
				}
			},
			optionsChange(e) {
				this.index = e.target.value
			},
			bindDateChange(e) {
				this.date = e.target.value
			},
			getDate(type) {
				const date = new Date();
				let year = date.getFullYear();
				let month = date.getMonth() + 1;
				let day = date.getDate();
				if (type === 'start') {
					year = year - 60;
				} else if (type === 'end') {
					year = year + 2;
				}
				month = month > 9 ? month : '0' + month;;
				day = day > 9 ? day : '0' + day;
				return `${year}-${month}-${day}`;
			},
			toggleTab(str) {
				if(this.ro[str]){
					return false
				}
				this.$refs[str].show();
			},
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
