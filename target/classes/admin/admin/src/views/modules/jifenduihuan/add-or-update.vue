<template>
	<div class="addEdit-block">
		<el-form
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item class="input" v-if="type!='info'"  label="礼品名称" prop="lipinmingcheng" >
					<el-input v-model="ruleForm.lipinmingcheng" placeholder="礼品名称" clearable  :readonly="ro.lipinmingcheng"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="礼品名称" prop="lipinmingcheng" >
					<el-input v-model="ruleForm.lipinmingcheng" placeholder="礼品名称" readonly></el-input>
				</el-form-item>
				<el-form-item class="upload" v-if="type!='info' && !ro.lipinfengmian" label="礼品封面" prop="lipinfengmian" >
					<file-upload
						tip="点击上传礼品封面"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.lipinfengmian?ruleForm.lipinfengmian:''"
						@change="lipinfengmianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item class="upload" v-else-if="ruleForm.lipinfengmian" label="礼品封面" prop="lipinfengmian" >
					<img v-if="ruleForm.lipinfengmian.substring(0,4)=='http'&&ruleForm.lipinfengmian.split(',w').length>1" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.lipinfengmian" width="100" height="100">
					<img v-else-if="ruleForm.lipinfengmian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.lipinfengmian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.lipinfengmian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="兑换数量" prop="lipinshuliang" >
					<el-input v-model.number="ruleForm.lipinshuliang" placeholder="兑换数量" clearable  :readonly="ro.lipinshuliang"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="兑换数量" prop="lipinshuliang" >
					<el-input v-model="ruleForm.lipinshuliang" placeholder="兑换数量" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="所需积分" prop="suoxujifen" >
					<el-input-number v-model="ruleForm.suoxujifen" placeholder="所需积分" :disabled="ro.suoxujifen"></el-input-number>
				</el-form-item>
				<el-form-item v-else class="input" label="所需积分" prop="suoxujifen" >
					<el-input v-model="ruleForm.suoxujifen" placeholder="所需积分" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="总积分" prop="zhiyuanjifen" >
					<el-input v-model="zhiyuanjifen" placeholder="总积分" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.zhiyuanjifen" label="总积分" prop="zhiyuanjifen" >
					<el-input v-model="ruleForm.zhiyuanjifen" placeholder="总积分" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="志愿者账号" prop="zhiyuanzhezhanghao" >
					<el-input v-model="ruleForm.zhiyuanzhezhanghao" placeholder="志愿者账号" clearable  :readonly="ro.zhiyuanzhezhanghao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="志愿者账号" prop="zhiyuanzhezhanghao" >
					<el-input v-model="ruleForm.zhiyuanzhezhanghao" placeholder="志愿者账号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="志愿者姓名" prop="zhiyuanzhexingming" >
					<el-input v-model="ruleForm.zhiyuanzhexingming" placeholder="志愿者姓名" clearable  :readonly="ro.zhiyuanzhexingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="志愿者姓名" prop="zhiyuanzhexingming" >
					<el-input v-model="ruleForm.zhiyuanzhexingming" placeholder="志愿者姓名" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="剩余积分" prop="shengyujifen" >
					<el-input-number v-model="ruleForm.shengyujifen" placeholder="剩余积分" :disabled="ro.shengyujifen"></el-input-number>
				</el-form-item>
				<el-form-item v-else class="input" label="剩余积分" prop="shengyujifen" >
					<el-input v-model="ruleForm.shengyujifen" placeholder="剩余积分" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="兑换时间" prop="duihuanshijian" >
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.duihuanshijian" 
						type="datetime"
						:readonly="ro.duihuanshijian"
						placeholder="兑换时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.duihuanshijian" label="兑换时间" prop="duihuanshijian" >
					<el-input v-model="ruleForm.duihuanshijian" placeholder="兑换时间" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-xihuan"></span>
					提交
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

	</div>
</template>
<script>
	import { 
		isNumber,
		isIntNumer,
	} from "@/utils/validate";
	export default {
		data() {
			var validateNumber = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isNumber(value)) {
					callback(new Error("请输入数字"));
				} else {
					callback();
				}
			};
			var validateIntNumber = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isIntNumer(value)) {
					callback(new Error("请输入整数"));
				} else {
					callback();
				}
			};
			return {
				id: '',
				uObject: null,
				type: '',
			
			
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

				rules: {
					lipinmingcheng: [
					],
					lipinfengmian: [
					],
					lipinshuliang: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					suoxujifen: [
						{ validator: validateNumber, trigger: 'blur' },
					],
					zhiyuanjifen: [
						{ validator: validateNumber, trigger: 'blur' },
					],
					zhiyuanzhezhanghao: [
					],
					zhiyuanzhexingming: [
					],
					shengyujifen: [
						{ validator: validateNumber, trigger: 'blur' },
					],
					duihuanshijian: [
					],
					crossuserid: [
					],
					crossrefid: [
					],
				},
			};
		},
		props: ["parent"],
		computed: {


			zhiyuanjifen:{
				get: function () {
					return 1*this.ruleForm.lipinshuliang*this.ruleForm.suoxujifen
				}
			},

		},
		components: {
		},
		created() {
			this.ruleForm.duihuanshijian = this.getCurDateTime()
		},
		methods: {
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(id,type) {
				if (id) {
					this.id = id;
					this.type = type;
				}
				if(this.type=='info'||this.type=='else'||this.type=='msg'){
					this.info(id);
				}else if(this.type=='logistics'){
					for(let x in this.ro) {
						this.ro[x] = true
					}
					this.logistics=false;
					this.info(id);
				}else if(this.type=='cross'){
					var obj = this.$storage.getObj('crossObj');
					for (var o in obj){
						if(o=='lipinmingcheng'){
							this.ruleForm.lipinmingcheng = obj[o];
							this.ro.lipinmingcheng = true;
							continue;
						}
						if(o=='lipinfengmian'){
							this.ruleForm.lipinfengmian = obj[o];
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
					this.ruleForm.lipinshuliang = 0
					this.ro.lipinshuliang = false;
				}
				// 获取用户信息
				this.$http({
					url: `${this.$storage.get('sessionTable')}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						var json = data.data;
						this.uObject = data.data;
						if(((json.zhiyuanzhezhanghao!=''&&json.zhiyuanzhezhanghao) || json.zhiyuanzhezhanghao==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.zhiyuanzhezhanghao = json.zhiyuanzhezhanghao
							this.ro.zhiyuanzhezhanghao = true;
						}
						if(((json.zhiyuanzhexingming!=''&&json.zhiyuanzhexingming) || json.zhiyuanzhexingming==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.zhiyuanzhexingming = json.zhiyuanzhexingming
							this.ro.zhiyuanzhexingming = true;
						}
						if(((json.zhiyuanjifen!=''&&json.zhiyuanjifen) || json.zhiyuanjifen==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.shengyujifen = json.zhiyuanjifen
							this.ro.shengyujifen = true;
						}
					} else {
						this.$message.error(data.msg);
					}
				});
			
			},
			// 多级联动参数

			info(id) {
				this.$http({
					url: `jifenduihuan/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					this.ruleForm.zhiyuanjifen = this.zhiyuanjifen
					if(this.ruleForm.lipinfengmian!=null) {
						this.ruleForm.lipinfengmian = this.ruleForm.lipinfengmian.replace(new RegExp(this.$base.url,"g"),"");
					}
					if(parseFloat(this.ruleForm.zhiyuanjifen)>parseFloat(this.ruleForm.shengyujifen)){
						this.$message.error("总积分不能超过剩余积分");
						return
					}
					var objcross = this.$storage.getObj('crossObj');
					var table = this.$storage.getObj('crossTable');
					if(objcross!=null) {
						if(!this.ruleForm.lipinshuliang){
							this.$message.error("兑换数量不能为空");
							return
						}
						objcross.lipinshuliang = objcross.lipinshuliang - this.ruleForm.lipinshuliang
						if(objcross.lipinshuliang<0){
							this.$message.error("兑换数量不足");
							return
						}
											}
					//更新跨表属性
					var crossuserid;
					var crossrefid;
					var crossoptnum;
					var finishNum = 0;
					if(!this.ruleForm.id) {
						delete this.ruleForm.userid
					}
					await this.$refs["ruleForm"].validate(async valid => {
						if (valid) {
							if(this.type=='cross'){
								var statusColumnName = this.$storage.get('statusColumnName');
								var statusColumnValue = this.$storage.get('statusColumnValue');
								if(statusColumnName!='') {
									var obj = this.$storage.getObj('crossObj');
									if(statusColumnName && !statusColumnName.startsWith("[")) {
										for (var o in obj){
											if(o==statusColumnName){
												obj[o] = statusColumnValue;
											}
										}
										var table = this.$storage.get('crossTable');
										await this.$http({
											url: `${table}/update`,
											method: "post",
											data: obj
										}).then(({ data }) => {});
										await this.$http({
											url: `${table}/update`,
											method: "post",
											data: objcross
										}).then(({ data }) => {});
									}
									else {
										crossuserid=this.$storage.get('userid');
										crossrefid=obj['id'];
										crossoptnum=this.$storage.get('statusColumnName');
										crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
									}
								}
								if(crossrefid && crossuserid) {
									this.ruleForm.crossuserid = crossuserid;
									this.ruleForm.crossrefid = crossrefid;
									let params = { 
										page: 1, 
										limit: 10, 
										crossuserid:this.ruleForm.crossuserid,
										crossrefid:this.ruleForm.crossrefid,
									} 
									await this.$http({ 
										url: "jifenduihuan/page", 
										method: "get", 
										params: params 
									}).then(({ 
										data 
									}) => { 
										if (data && data.code === 0) {
											finishNum = data.data.total
										}
									})
								}
								if(finishNum>=crossoptnum) {
									this.$message.error(this.$storage.get('tips'));
									return false;
								}
							}
							
							await this.$http({
								url: `jifenduihuan/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(async ({ data }) => {
								if (data && data.code === 0) {
									if(this.uObject.zhiyuanjifen>=0){
										this.uObject.zhiyuanjifen = parseFloat(this.uObject.zhiyuanjifen) - parseFloat(this.ruleForm.zhiyuanjifen)
										await this.$http({url: `${this.$storage.get('sessionTable')}/update`,method: "post",data: this.uObject}).then(res => {});
									}
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.jifenduihuanCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
									var table = this.$storage.get('crossTable');
									await this.$http({
										url: `${table}/update`,
										method: "post",
										data: objcross
									}).then(({ data }) => {});
								} else {
									this.$message.error(data.msg);
								}
							});
						}
					});
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 返回
			back() {
				this.parent.showFlag = true;
				this.parent.addOrUpdateFlag = false;
				this.parent.jifenduihuanCrossAddOrUpdateFlag = false;
				this.parent.contentStyleChange();
			},
			lipinfengmianUploadChange(fileUrls) {
				this.ruleForm.lipinfengmian = fileUrls;
			},
		}
	};
</script>
<style lang="scss" scoped>
	.addEdit-block {
		padding: 0px 30px 30px;
		margin: 0 auto;
		background: none;
		width: calc(100% - 0px);
		font-size: 15px;
	}
	.add-update-preview {
		border-radius: 10px;
		padding: 40px 0;
		background: #fff;
		width: 100%;
		border-color: #eee;
		border-width: 0px 0 0;
		border-style: solid;
	}
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	.add-update-preview /deep/ .el-form-item {
		border: 0px solid #eee;
		padding: 0;
		margin: 0 0 26px 0;
		display: inline-block;
		width: 49%;
		text-align: left;
	}
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
		padding: 0 10px 0 0;
		color: #333;
		font-weight: 500;
		width: 180px;
		font-size: 15px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
		margin-left: 180px;
	}
	.add-update-preview .el-form-item span.text {
		border: 1px solid #eee;
		padding: 10px 10px;
		color: #333;
		background: #fff;
		font-weight: 500;
		display: inline-block;
		font-size: 15px;
		line-height: 1.5;
		min-width: 100%;
	}
	
	.add-update-preview .el-input {
		width: 100%;
		text-align: left;
	}
	.add-update-preview .el-input /deep/ .el-input__inner {
		border: 1px solid #e8e8e8;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		width: 100%;
		font-size: 15px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-input /deep/ .el-input__inner[readonly="readonly"] {
		border: 0px solid #ccc;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: none;
		width: 100%;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .el-input-number {
		text-align: left;
		width: 100%;
		text-align: left;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
		border: 1px solid #e8e8e8;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		width: 100%;
		font-size: 15px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .is-disabled .el-input__inner {
		text-align: left;
		border: 0px solid #ccc;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: none;
		width: 100%;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	.add-update-preview .el-select {
		width: 100%;
		text-align: left;
	}
	.add-update-preview .el-select /deep/ .el-input__inner {
		border: 1px solid #e8e8e8;
		border-radius: 0px;
		padding: 0 10px;
		color: #666;
		width: 100%;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .el-select /deep/ .is-disabled .el-input__inner {
		border: 0;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 0 10px;
		color: #666;
		background: none;
		width: 100%;
		font-size: 15px;
		height: 34px;
	}
	.add-update-preview .el-date-editor {
		width: 100%;
		text-align: left;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
		border: 1px solid #e8e8e8;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #666;
		background: #fff;
		width: 100%;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
		border: 0;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #666;
		background: none;
		width: 100%;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .viewBtn {
		border: 1px solid #eee;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 10px;
		margin: 0 20px 0 0;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .viewBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .downBtn {
		border: 1px solid #eee;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 10px;
		margin: 0 20px 0 0;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .downBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .unBtn {
		border: 1px solid #eee;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 0 20px;
		margin: 0 20px 0 0;
		outline: none;
		color: #999;
		background: none;
		width: auto;
		font-size: 15px;
		line-height: 40px;
		height: 40px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 34px;
		}
	}
	.add-update-preview .unBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
		border: 1px solid #e8e8e8;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
		border: 1px solid #e8e8e8;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
		border: 1px solid #e8e8e8;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	.add-update-preview /deep/ .el-upload__tip {
		color: #666;
		font-size: 15px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
		border: 1px solid #e8e8e8;
		border-radius: 0px;
		padding: 12px;
		color: #666;
		background: #fff;
		width: 100%;
		font-size: 15px;
		min-width: 400px;
		height: 120px;
	}
	.add-update-preview .el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
				border: 0;
				cursor: not-allowed;
				border-radius: 0px;
				padding: 12px;
				color: #666;
				background: none;
				width: 100%;
				font-size: 14px;
				min-width: 400px;
				height: auto;
			}
	.add-update-preview .el-form-item.btn {
		padding: 0;
		margin: 20px 0 0;
		width: 100%;
		text-align: center;
		.btn1 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #05aeff;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn1:hover {
			opacity: 0.8;
		}
		.btn2 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #ffc144;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 34px;
			}
		}
		.btn2:hover {
			opacity: 0.8;
		}
		.btn3 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #ff837a;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn3:hover {
			opacity: 0.8;
		}
		.btn4 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #ffce52;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn4:hover {
			opacity: 0.8;
		}
		.btn5 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #90a0ff;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn5:hover {
			opacity: 0.8;
		}
	}
</style>
