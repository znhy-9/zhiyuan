<template>
<view class="content">
	<view class="box" :style='{"minHeight":"100vh","width":"100%","padding":"96rpx 24rpx 24rpx","background":"url(http://codegen.caihongy.cn/20241028/5f4c84f34c1148d3abacba44f9b6b133.jpg) no-repeat center top / cover,#fff","height":"auto"}'>
		<view :style='{"border":"2rpx solid #ddd","padding":"48rpx 0px 24rpx 48rpx","borderRadius":"20rpx","textAlign":"center","background":"rgba(255,255,255,.3)","display":"block","width":"100%","position":"relative","height":"auto"}'>
			<image :style='{"width":"160rpx","margin":"0 auto 24rpx auto","borderRadius":"8rpx","display":"none","height":"160rpx"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" mode="aspectFill"></image>
			<view :style='{"border":"2rpx solid #ddd","width":"calc(100% - 48rpx)","margin":"0 0 24rpx 0","background":"rgba(255, 255, 255,.8)","display":"flex","height":"auto"}' v-if="tableName=='zhiyuanzhe'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#000"}' class="label">志愿者账号：</view>
				<input :style='{"border":"0px solid #ddd","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"none","fontSize":"28rpx","lineHeight":"80rpx","height":"auto"}'  v-model="ruleForm.zhiyuanzhezhanghao"  type="text"  class="uni-input" name="" placeholder="志愿者账号" />
			</view>
			<view :style='{"border":"2rpx solid #ddd","width":"calc(100% - 48rpx)","margin":"0 0 24rpx 0","background":"rgba(255, 255, 255,.8)","display":"flex","height":"auto"}' v-if="tableName=='zhiyuanzhe'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#000"}' class="label">密码：</view>
				<input :style='{"border":"0px solid #ddd","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"none","fontSize":"28rpx","lineHeight":"80rpx","height":"auto"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"border":"2rpx solid #ddd","width":"calc(100% - 48rpx)","margin":"0 0 24rpx 0","background":"rgba(255, 255, 255,.8)","display":"flex","height":"auto"}' v-if="tableName=='zhiyuanzhe'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#000"}' class="label">确认密码：</view>
				<input :style='{"border":"0px solid #ddd","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"none","fontSize":"28rpx","lineHeight":"80rpx","height":"auto"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
			<view :style='{"border":"2rpx solid #ddd","width":"calc(100% - 48rpx)","margin":"0 0 24rpx 0","background":"rgba(255, 255, 255,.8)","display":"flex","height":"auto"}' v-if="tableName=='zhiyuanzhe'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#000"}' class="label">志愿者姓名：</view>
				<input :style='{"border":"0px solid #ddd","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"none","fontSize":"28rpx","lineHeight":"80rpx","height":"auto"}'  v-model="ruleForm.zhiyuanzhexingming"  type="text"  class="uni-input" name="" placeholder="志愿者姓名" />
			</view>
            <view :style='{"border":"2rpx solid #ddd","width":"calc(100% - 48rpx)","margin":"0 0 24rpx 0","background":"rgba(255, 255, 255,.8)","display":"flex","height":"auto"}' v-if="tableName=='zhiyuanzhe'" class="">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#000"}' class="label">性别：</view>
				<picker :style='{"width":"100%","alignItems":"center","display":"flex","height":"auto"}' v-if="tableName=='zhiyuanzhe'"  @change="zhiyuanzhexingbieChange" :value="zhiyuanzhexingbieIndex" :range="zhiyuanzhexingbieOptions">
					<view>
						<view :style='{"fontSize":"28rpx","lineHeight":"80rpx","color":"#888","textAlign":"left","height":"auto"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
					</view>
				</picker>
			</view>
			<view :style='{"border":"2rpx solid #ddd","width":"calc(100% - 48rpx)","margin":"0 0 24rpx 0","background":"rgba(255, 255, 255,.8)","display":"flex","height":"auto"}' v-if="tableName=='zhiyuanzhe'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#000"}' class="label">手机号：</view>
				<input :style='{"border":"0px solid #ddd","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"none","fontSize":"28rpx","lineHeight":"80rpx","height":"auto"}'  v-model="ruleForm.shoujihao"  type="text"  class="uni-input" name="" placeholder="手机号" />
			</view>
            <view :style='{"border":"2rpx solid #ddd","width":"calc(100% - 48rpx)","margin":"0 0 24rpx 0","background":"rgba(255, 255, 255,.8)","display":"flex","height":"auto"}' v-if="tableName=='zhiyuanzhe'" @tap="zhiyuanzhetouxiangTap" class="">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#000"}' class="label">头像：</view>
				<image :style='{"width":"120rpx","margin":"6rpx 0 0","borderRadius":"16rpx","objectFit":"cover","display":"block","height":"80rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"120rpx","margin":"6rpx 0 0","borderRadius":"16rpx","objectFit":"cover","display":"block","height":"80rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<view :style='{"border":"2rpx solid #ddd","width":"calc(100% - 48rpx)","margin":"0 0 24rpx 0","background":"rgba(255, 255, 255,.8)","display":"flex","height":"auto"}' v-if="tableName=='zhiyuanzhe'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#000"}' class="label">志愿积分：</view>
				<input :style='{"border":"0px solid #ddd","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"none","fontSize":"28rpx","lineHeight":"80rpx","height":"auto"}' :disabled="true" v-model="ruleForm.zhiyuanjifen"  type="text"  class="uni-input" name="" placeholder="志愿积分" />
			</view>
			<button :style='{"border":"0","padding":"0 40rpx","margin":"24rpx 0 24rpx 0","color":"rgb(255, 255, 255)","borderRadius":"8rpx","background":"#EF7061","display":"inline-block","width":"auto","lineHeight":"88rpx","fontSize":"32rpx","minWidth":"200rpx","height":"88rpx"}' class="btn-submit" @tap="register" type="primary">注册</button>
			
			<view class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea1</view>
			<view class="idea2" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea2</view>
			<view class="idea3" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea3</view>
		</view>
	</view>
</view>
</template>

<script>
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
                zhiyuanzhexingbieOptions: [],
                zhiyuanzhexingbieIndex: 0,
				ruleForm: {
                zhiyuanzhezhanghao: '',
                mima: '',
                zhiyuanzhexingming: '',
                xingbie: '',
                shoujihao: '',
                touxiang: '',
                zhiyuanjifen: '0',
				},
				tableName:""
			}
		},
        components: {
            multipleSelect
        },
        computed: {
            baseUrl() {
                return this.$base.url;
            },
        },
		async onLoad() {
			let res = [];
			let table = uni.getStorageSync("loginTable");
            this.tableName = table;

                        // 自定义下拉框值
			if(this.tableName=='zhiyuanzhe'){
                this.zhiyuanzhexingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.zhiyuanzhexingbieOptions[0]
			}
            if(`zhiyuanzhe` == this.tableName){
                this.ruleForm.zhiyuanjifen='0'
            }
			
			this.styleChange()
		},
		methods: {

            // 下拉变化
            zhiyuanzhexingbieChange(e) {
                    this.zhiyuanzhexingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.zhiyuanzhexingbieOptions[this.zhiyuanzhexingbieIndex]
            },
            zhiyuanzhetouxiangTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
                });
            },

            toggleTab(str) {
                this.$refs[str].show();
            },

			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.registerFrom.content.input.backgroundColor
					// })
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 注册
			async register() {
				
				if((!this.ruleForm.zhiyuanzhezhanghao) && `zhiyuanzhe` == this.tableName){
					this.$utils.msg(`志愿者账号不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `zhiyuanzhe` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
                if(`zhiyuanzhe` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if((!this.ruleForm.zhiyuanzhexingming) && `zhiyuanzhe` == this.tableName){
					this.$utils.msg(`志愿者姓名不能为空`);
					return
				}
				if(`zhiyuanzhe` == this.tableName && this.ruleForm.shoujihao&&(!this.$validate.isMobile(this.ruleForm.shoujihao))){
					this.$utils.msg(`手机号应输入手机格式`);
					return
				}
				await this.$api.register(`${this.tableName}`, this.ruleForm);
				this.$utils.msgBack('注册成功');;
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
