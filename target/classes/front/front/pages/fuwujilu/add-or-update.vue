<template>
<view class="content">
	<view :style='{"width":"100%","padding":"40rpx 0 0","position":"relative","background":"#f7f7f7","height":"100%"}'>
		<form :style='{"width":"100%","padding":"24rpx","background":"none","display":"block","height":"auto"}' class="app-update-pv">
			<view :style='{"padding":"12rpx 0","boxShadow":"2rpx 0px 0px 0px #DCD0C050, 0px 2rpx 0px 0px #B1938B50, -2rpx 0px 0px 0px #98737350, 0px 0px 0px 2rpx #DA635D50","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0 60rpx 0 0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">标题</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.biaoti" v-model="ruleForm.biaoti" placeholder="标题"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"2rpx 0px 0px 0px #DCD0C050, 0px 2rpx 0px 0px #B1938B50, -2rpx 0px 0px 0px #98737350, 0px 0px 0px 2rpx #DA635D50","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0 60rpx 0 0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="" @tap="fengmianTap">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">封面</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-if="ruleForm.fengmian" :src="baseUrl+ruleForm.fengmian.split(',')[0]" mode="aspectFill"></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"2rpx 0px 0px 0px #DCD0C050, 0px 2rpx 0px 0px #B1938B50, -2rpx 0px 0px 0px #98737350, 0px 0px 0px 2rpx #DA635D50","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0 60rpx 0 0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">服务地点</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.fuwudidian" v-model="ruleForm.fuwudidian" placeholder="服务地点"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"2rpx 0px 0px 0px #DCD0C050, 0px 2rpx 0px 0px #B1938B50, -2rpx 0px 0px 0px #98737350, 0px 0px 0px 2rpx #DA635D50","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0 60rpx 0 0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">服务时长</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.fuwushizhang" v-model="ruleForm.fuwushizhang" placeholder="服务时长"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"2rpx 0px 0px 0px #DCD0C050, 0px 2rpx 0px 0px #B1938B50, -2rpx 0px 0px 0px #98737350, 0px 0px 0px 2rpx #DA635D50","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0 60rpx 0 0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">活动积分</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.zhiyuanjifen" v-model="ruleForm.zhiyuanjifen" placeholder="活动积分"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"2rpx 0px 0px 0px #DCD0C050, 0px 2rpx 0px 0px #B1938B50, -2rpx 0px 0px 0px #98737350, 0px 0px 0px 2rpx #DA635D50","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0 60rpx 0 0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="" @tap="wenjianTap">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">文件</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' v-if="ruleForm.wenjian"  v-model="baseUrl+ruleForm.wenjian" placeholder="文件"></input>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
			</view>
			<view :style='{"padding":"12rpx 0","boxShadow":"2rpx 0px 0px 0px #DCD0C050, 0px 2rpx 0px 0px #B1938B50, -2rpx 0px 0px 0px #98737350, 0px 0px 0px 2rpx #DA635D50","margin":"0 0 24rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0 60rpx 0 0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">登记时间</view>
				<picker  :disabled="ro.dengjishijian" :style='{"width":"100%","flex":"1","height":"auto"}' mode="date" :value="ruleForm.dengjishijian" @change="dengjishijianChange">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(255, 170, 51)"}' class="uni-input">{{ruleForm.dengjishijian?ruleForm.dengjishijian:"请选择登记时间"}}</view>
				</picker>
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
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">手机号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.shoujihao" v-model="ruleForm.shoujihao" placeholder="手机号"  type="text"></input>
			</view>
             
			<view :style='{"padding":"10rpx 20rpx","boxShadow":"2rpx 0px 0px 0px #DCD0C050, 0px 2rpx 0px 0px #B1938B50, -2rpx 0px 0px 0px #98737350, 0px 0px 0px 2rpx #DA635D50","margin":"0 0 24rpx 0","borderColor":"#ccc","borderRadius":"0 60rpx 0 0","borderWidth":"0 0 0px 0","background":"#fff","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","fontWeight":"600"}' class="title">贡献详情</view>
				<xia-editor ref="gongxianxiangqing" :style='{"minHeight":"300rpx","border":"0px solid #efefef","width":"100%","height":"auto"}' v-model="ruleForm.gongxianxiangqing" placeholder="贡献详情" @editorChange="gongxianxiangqingChange"></xia-editor>
			</view>
			
			<view :style='{"width":"100%","justifyContent":"center","display":"flex","height":"auto"}' class="btn" >
				<button :style='{"border":"0","padding":"0px","margin":"0 40rpx 0 0","color":"rgb(255, 255, 255)","borderRadius":"0 60rpx 0 0","background":"#ef7061","width":"250rpx","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' @tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

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
				biaoti: '',
				fengmian: '',
				fuwudidian: '',
				fuwushizhang: '',
				zhiyuanjifen: '',
				wenjian: '',
				gongxianxiangqing: '',
				dengjishijian: '',
				zhiyuanzhezhanghao: '',
				zhiyuanzhexingming: '',
				shoujihao: '',
				shhf: '',
				},
				// 登录用户信息
				user: {},
				ro:{
				   biaoti : false,
				   fengmian : false,
				   fuwudidian : false,
				   fuwushizhang : false,
				   zhiyuanjifen : false,
				   wenjian : false,
				   gongxianxiangqing : false,
				   dengjishijian : false,
				   zhiyuanzhezhanghao : false,
				   zhiyuanzhexingming : false,
				   shoujihao : false,
				   sfsh : false,
				   shhf : false,
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



		},
		async onLoad(options) {
			if(options.virtualPay){
				this.virtualPay = true
			}
			this.ruleForm.dengjishijian = this.$utils.getCurDate();
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取
			this.ruleForm.zhiyuanzhezhanghao = this.user.zhiyuanzhezhanghao
			this.ro.zhiyuanzhezhanghao = true;
			this.ruleForm.zhiyuanzhexingming = this.user.zhiyuanzhexingming
			this.ro.zhiyuanzhexingming = true;
			this.ruleForm.shoujihao = this.user.shoujihao
			this.ro.shoujihao = true;



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
				res = await this.$api.info(`fuwujilu`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
					if(o=='biaoti'){
						this.ruleForm.biaoti = obj[o];
						this.ro.biaoti = true;
						continue;
					}
					if(o=='fengmian'){
						this.ruleForm.fengmian = obj[o].split(",")[0];
						this.ro.fengmian = true;
						continue;
					}
					if(o=='fuwudidian'){
						this.ruleForm.fuwudidian = obj[o];
						this.ro.fuwudidian = true;
						continue;
					}
					if(o=='fuwushizhang'){
						this.ruleForm.fuwushizhang = obj[o];
						this.ro.fuwushizhang = true;
						continue;
					}
					if(o=='zhiyuanjifen'){
						this.ruleForm.zhiyuanjifen = obj[o];
						this.ro.zhiyuanjifen = true;
						continue;
					}
					if(o=='wenjian'){
						this.ruleForm.wenjian = obj[o];
						this.ro.wenjian = true;
						continue;
					}
					if(o=='gongxianxiangqing'){
						this.ruleForm.gongxianxiangqing = obj[o];
						this.ro.gongxianxiangqing = true;
						continue;
					}
					if(o=='dengjishijian'){
						this.ruleForm.dengjishijian = obj[o];
						this.ro.dengjishijian = true;
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
					if(o=='shoujihao'){
						this.ruleForm.shoujihao = obj[o];
						this.ro.shoujihao = true;
						continue;
					}
				}
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
			gongxianxiangqingChange(e) {
				this.ruleForm.gongxianxiangqing = e
			},
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.app-update-pv . .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.addUpdateForm.input.content.backgroundColor
					// })
				})
			},

			// 多级联动参数

			dengjishijianChange(e) {
				this.ruleForm.dengjishijian = e.target.value;
				this.$forceUpdate();
			},



			fengmianTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.fengmian = 'upload/' + res.file;
					_this.$forceUpdate();
					_this.$nextTick(()=>{
						_this.styleChange()
					})
				});
			},
			wenjianTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.wenjian = 'upload/' + res.file;
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
				//跨表计算判断
				var obj;
				if((!this.ruleForm.biaoti)){
					this.$utils.msg(`标题不能为空`);
					return
				}
				if(this.ruleForm.shoujihao&&(!this.$validate.isMobile(this.ruleForm.shoujihao))){
					this.$utils.msg(`手机号应输入手机格式`);
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
					let res = await this.$api.list(`fuwujilu`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
						uni.removeStorageSync('crossCleanType');
						return false;
					} else {
				//跨表计算
						let oet = {}
						if(this.ruleForm.id){
							await this.$api.update(`fuwujilu`, this.ruleForm);
						}else{
							oet = await this.$api.add(`fuwujilu`, this.ruleForm);
						 if(this.user.zhiyuanjifen>=0) {
							 this.user.zhiyuanjifen = parseFloat(this.user.zhiyuanjifen) + parseFloat(this.ruleForm.zhiyuanjifen)
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
					let oet = {}
					if(this.ruleForm.id){
						await this.$api.update(`fuwujilu`, this.ruleForm);
					}else{
						oet = await this.$api.add(`fuwujilu`, this.ruleForm);
						 if(this.user.zhiyuanjifen>=0) {
							 this.user.zhiyuanjifen = parseFloat(this.user.zhiyuanjifen) + parseFloat(this.ruleForm.zhiyuanjifen)
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
