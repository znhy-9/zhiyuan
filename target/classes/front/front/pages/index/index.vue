<template>
	<view class="content">
		<view :style='{"alignContent":"flex-start","alignItems":"flex-start","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","height":"auto"}'>
			<view class="list-swiper-4" :style='{"width":"100%","position":"relative","height":"360rpx"}' @touchstart="touchStart" @touchmove="touchMove" @touchend="touchEnd">
				<view :style='{"width":"100%","position":"absolute","top":"0%","left":"0%","background":"#fff","height":"360rpx"}' class="item animate__animated" :class="prevNumList4 == index  ? 'animate__backOutRight' : (numList4 == index  ? 'animate__zoomInLeft' : '')" v-for="(swiper,index) in swiperList" :key="index" v-if="numList4 == index || prevNumList4 == index">
					<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' mode="aspectFill" :src="baseUrl+swiper.img" @tap="onSwiperTap(swiper)"></image>
					<view :style='{"padding":"8rpx 20rpx","margin":"-20rpx 0 0 0","transform":"translate3d(-50%, -50%, 0)","top":"50%","color":"#000","left":"50%","background":"rgba(255, 255, 255, 0.3)","display":"none","lineHeight":"1.5","fontSize":"40rpx","position":"absolute"}'>{{ swiper.title }}</view>
				</view>
				<view class="animate__navigation" :style='{"alignItems":"center","left":"0%","bottom":"20rpx","background":"rgba(0,0,0,0)","display":"flex","width":"100%","position":"absolute","justifyContent":"center","height":"40rpx"}'>
					<block v-for="(swiper,index) in swiperList" :key="index">
						<text class="navigation-item" v-if="numList4 == index" :style='{"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#EF7061","height":"16rpx"}'></text>
						<text class="navigation-item" v-if="numList4 != index" :style='{"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#fff","height":"16rpx"}'></text>
					</block>
				</view>
			</view>
			<!-- menu -->
			<view v-if="true" class="menu_view">
				<block v-for="(item,index1) in menuList" v-bind:key="item.roleName">
					<block v-if="index1==0" v-bind:key="index" v-for=" (menu,index) in item.frontMenu">
						<block v-bind:key="sort" v-for=" (child,sort) in menu.child">
							<block v-bind:key="sort2" v-for=" (button,sort2) in child.buttons">
								<view class="menu-item" v-if="button=='查看' && child.tableName!='yifahuodingdan' && child.tableName!='yituikuandingdan' &&child.tableName!='yiquxiaodingdan' && child.tableName!='weizhifudingdan' && child.tableName!='yizhifudingdan' && child.tableName!='yiwanchengdingdan' " @tap="onPageTap2(child.tableName)">
									<view class="iconarr" :class="child.appFrontIcon" :style="{'color':menuColor[index]}"></view>
									
									<view class="text">{{child.menu.split("列表")[0]}}</view>
								</view>
							</block>
						</block>
					</block>
				</block>
			</view>
			<!-- 关于我们 -->
			<view :style='{"padding":"0 24rpx","margin":"40rpx auto","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","position":"relative","height":"auto","order":"2"}'>
				<view :style='{"margin":"0 0 40rpx","color":"#fff","borderRadius":"0 60rpx  0 0","textAlign":"center","background":"url(http://codegen.caihongy.cn/20241025/2f5aea076ec345abb2ef9e6289f2c5a7.png) no-repeat left center / auto 100%,#ef7061","width":"100%","lineHeight":"80rpx","fontSize":"36rpx"}'>{{aboutUsDetail.title}}</view>
				<view :style='{"margin":"0 0 20rpx","color":"#999","textAlign":"center","display":"none","width":"100%","lineHeight":"1.5","fontSize":"32rpx"}'>{{aboutUsDetail.subtitle}}</view>
				<view :style='{"width":"100%","padding":"0","margin":"20rpx 0 0","flexWrap":"wrap","display":"flex","height":"auto"}'>
					<img :style='{"margin":"0","objectFit":"cover","borderRadius":"60rpx 0 0 0","flex":1,"display":"block","height":"300rpx"}' v-if="aboutUsDetail.picture1" :src="baseUrl+aboutUsDetail.picture1">
					<img :style='{"margin":"0","objectFit":"cover","borderRadius":"0 60rpx 0 0","flex":1,"display":"block","height":"300rpx"}' v-if="aboutUsDetail.picture2" :src="baseUrl+aboutUsDetail.picture2">
					<img :style='{"margin":"0 10rpx","objectFit":"cover","flex":1,"display":"none","height":"160rpx"}' v-if="aboutUsDetail.picture3" :src="baseUrl+aboutUsDetail.picture3">
				</view>
				<view :style='{"padding":"20rpx 20rpx 60rpx","margin":"0px 0 20rpx 0","color":"rgb(102, 102, 102)","borderRadius":"0 0 60rpx 60rpx","background":"#ef706115","width":"100%","lineHeight":"1.8","fontSize":"28rpx"}' v-html="aboutUsDetail.content"></view>
				<view :style='{"border":"0","padding":"0 30rpx","margin":"0 auto","top":"10rpx","textAlign":"center","background":"none","display":"block","width":"auto","lineHeight":"56rpx","position":"absolute","right":"40rpx","zIndex":"999"}' @tap="onDetailTap('aboutus',1)">
					<text :style='{"color":"#fff","fontSize":"28rpx"}'>更多 +</text>
					<text class="icon iconfont icon-tianjia14" :style='{"color":"#f5f5f5","fontSize":"28rpx","display":"none"}'></text>
				</view>
				<view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
				<view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
			</view>
			<!-- 商品推荐 -->
			<!-- 商品推荐 -->
			
			<!-- 商品列表 -->
			<view class="listBox list" :style='{"width":"100%","padding":"0 24rpx","margin":"40rpx auto","background":"#fff","order":"3"}'>
				<view class="title" :style='{"margin":"0 0 40rpx","color":"#fff","borderRadius":"0 60rpx  0 0","textAlign":"center","background":"url(http://codegen.caihongy.cn/20241025/2f5aea076ec345abb2ef9e6289f2c5a7.png) no-repeat left center / auto 100%,#ef7061","width":"100%","lineHeight":"80rpx","fontSize":"36rpx","position":"relative"}'>
					<view :style='{"color":"#fff","fontSize":"36rpx","lineHeight":"88rpx"}'>志愿活动</view>
					<view :style='{"alignItems":"center","top":"4rpx","display":"flex","position":"absolute","right":"40rpx","justifyContent":"center","zIndex":"999"}' @tap="onPageTap('zhiyuanhuodong')">
					  <text :style='{"color":"#fff","fontSize":"28rpx"}'>更多 +</text>
					  <text class="icon iconfont icon-gengduo1" :style='{"color":"#fff","fontSize":"28rpx","display":"none"}'></text>
					</view>
				</view>
				<!-- 样式3 -->
				<view v-if="3 == 3" class="list-box style3" :style='{"width":"100%","padding":"0","margin":"0","height":"auto"}'>
					<view @tap="onDetailTap('zhiyuanhuodong',product.id)" v-for="(product,index) in homezhiyuanhuodonglist" :key="index" class="list-item" :style='{"boxShadow":"2rpx 0px 0px 0px #DCD0C050, 0px 2rpx 0px 0px #B1938B50, -2rpx 0px 0px 0px #98737350, 0px 0px 0px 2rpx #DA635D50","padding":"20rpx","margin":"0 0 40rpx","backgroundColor":"#fff","borderRadius":"0 60rpx  0 0","color":"#999","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"28rpx","height":"auto"}'>
						<image :style='{"width":"200rpx","objectFit":"cover","borderRadius":"40rpx","display":"block","height":"240rpx"}' class="list-item-image" mode="aspectFill" v-if="product.fengmian.substring(0,4)=='http'" :src="product.fengmian"></image>
						<image :style='{"width":"200rpx","objectFit":"cover","borderRadius":"40rpx","display":"block","height":"240rpx"}' class="list-item-image" mode="aspectFill" v-else :src="product.fengmian?baseUrl+product.fengmian.split(',')[0]:''"></image>
						<view class="list-item-body" :style='{"width":"calc(100% - 200rpx)","padding":"0","margin":"0","height":"auto"}'>
							<view :style='{"padding":"4rpx 20rpx","overflow":"hidden","whiteSpace":"nowrap","color":"#333","width":"100%","lineHeight":"60rpx","fontSize":"28rpx","textOverflow":"ellipsis"}' class="list-item-title">{{product.biaoti}}</view>
							<view :style='{"padding":"4rpx 20rpx","overflow":"hidden","whiteSpace":"nowrap","color":"#333","width":"100%","lineHeight":"60rpx","fontSize":"28rpx","textOverflow":"ellipsis"}' class="list-item-title">活动积分:{{product.zhiyuanjifen}}</view>
							<view :style='{"color":"#EF7061","padding":"0 20rpx"}'>
								<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></text>
								<text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{product.addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
							</view>
							<view :style='{"color":"#bd8b3a","padding":"0 20rpx","display":"inline-block"}'>
								<text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></text>
								<text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{product.thumbsupnum}}</text>
							</view>
							<view :style='{"color":"#40bd3a","padding":"0 20rpx","display":"inline-block"}'>
								<text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></text>
								<text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{product.storeupnum}}</text>
							</view>
						</view>
					</view>
				</view>
			</view>
			<!-- 商品列表 -->
			<!-- 新闻资讯 -->
			<view class="listBox news" :style='{"padding":"0 24rpx","margin":"40rpx auto","color":"#999","background":"#fff","width":"100%","fontSize":"28rpx","order":"5"}'>
				<view class="title" :style='{"margin":"0 0 40rpx","color":"#fff","borderRadius":"0 60rpx  0 0","textAlign":"center","background":"url(http://codegen.caihongy.cn/20241025/2f5aea076ec345abb2ef9e6289f2c5a7.png) no-repeat left center / auto 100%,#ef7061","width":"100%","lineHeight":"80rpx","fontSize":"32rpx","position":"relative"}'>
					<view :style='{"color":"#fff","fontSize":"36rpx","lineHeight":"88rpx"}'>公告栏</view>
					<view :style='{"alignItems":"center","top":"4rpx","display":"flex","position":"absolute","right":"40rpx","justifyContent":"center","zIndex":"999"}' @tap="onPageTap('news')">
					  <text :style='{"color":"#fff","fontSize":"28rpx"}'>更多 +</text>
					  <text class="icon iconfont icon-gengduo1" :style='{"color":"#fff","fontSize":"28rpx","display":"none"}'></text>
					</view>
				</view>
				<!-- 样式9 -->
				<view class="news-box6" :style='{"width":"100%","padding":"0","margin":"0","height":"auto"}'>
					<view @tap="onNewsDetailTap(item.id)" v-for="(item,index) in news" :key="index" class="list-item" :style='{"boxShadow":"none","padding":"0","margin":"0 0 40rpx","backgroundColor":"#fff","borderRadius":"40rpx","flexWrap":"wrap","display":"flex","width":"100%","position":"relative","height":"auto"}'>
						<view :style='{"padding":"0","margin":"0 0 0 0","color":"#ef7061","textAlign":"center","right":"0","borderRadius":"0 60rpx 0 40rpx","top":"0","background":" #EF706150","width":"72rpx","lineHeight":"68rpx","fontSize":"28rpx","position":"absolute","height":"72rpx"}' class="num">
							<view style="width: 100%;height: 100%;position: absolute;left: 0;top: 0;" :style="{transform: 'rotate('+(-index*60)+'deg)'}" class="dian">
								<view :style='{"transform":"translateX(-50%)","borderRadius":"100%","top":"-8rpx","left":"50%","background":"red","display":"none","width":"16rpx","position":"absolute","height":"16rpx"}'></view>
							</view>{{ index + 1 < 10 ? '0'+(index+1) : index+1 }}
						</view>
						<view class="item-list-body" :style='{"width":"100%","boxShadow":"2rpx 0px 0px 0px #DCD0C050, 0px 2rpx 0px 0px #B1938B50, -2rpx 0px 0px 0px #98737350, 0px 0px 0px 2rpx #DA635D50","padding":"20rpx 20rpx","margin":"0","borderRadius":"0 60rpx  0 0","height":"auto"}'>
							<view :style='{"padding":"4rpx 0","overflow":"hidden","whiteSpace":"nowrap","color":"#333","width":"90%","lineHeight":"60rpx","fontSize":"28rpx","textOverflow":"ellipsis","fontWeight":"600"}' class="title ">{{item.title}}</view>
							<view :style='{"padding":"0","margin":"0 0 20rpx 0","overflow":"hidden","color":"#666","maxHeight":"192rpx","width":"100%","lineHeight":"48rpx","fontSize":"28rpx"}' class="text">{{item.introduction}}</view>
							<view :style='{"color":"#EF7061","margin":"0 20rpx 0 0","display":"inline-block"}'>
								<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></text>
								<text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
							</view>
							<view :style='{"color":"#3a8abd","margin":"0 20rpx 0 0","display":"inline-block"}'>
								<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></text>
								<text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.name}}</text>
							</view>
							<view :style='{"color":"#bd8d3a","margin":"0 20rpx 0 0","display":"inline-block"}'>
								<text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></text>
								<text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.thumbsupnum}}</text>
							</view>
							<view :style='{"color":"#3abd4c","margin":"0 20rpx 0 0","display":"inline-block"}'>
								<text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></text>
								<text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.storeupnum}}</text>
							</view>
							<view :style='{"color":"#3abdbb","margin":"0 20rpx 0 0","display":"inline-block"}'>
								<text class="icon iconfont icon-chakan2" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></text>
								<text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.clicknum}}</text>
							</view>
						</view>
					</view>
				</view>
			</view>
			<!-- 新闻资讯 -->
			<view v-if="scrollTop>200" @tap="scrollTopClick" :style='{"boxShadow":"0 8rpx 16rpx rgba(0,0,0,.3)","borderRadius":"50%","textAlign":"center","bottom":"20%","background":"#ff000030","width":"60rpx","lineHeight":"60rpx","position":"fixed","right":"20rpx","height":"60rpx"}'>
				<span class="icon iconfont icon-jiantou07" :style='{"color":"#fff"}'></span>
			</view>
		</view>
	</view>
</template>

<script>
    import menu from '@/utils/menu'
	import '@/assets/css/global-restaurant.css'
	import uniIcons from "@/components/uni-ui/lib/uni-icons/uni-icons.vue"
	export default {
		components: {
			uniIcons
		},
		data() {
			return {
				startX: 0,
				prevNumList4: '',
				numList4: 0,
				timerList4: null,
				flagList4: false,
				navigationActive: {"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#EF7061","height":"16rpx"},
				navigationDefault: {"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#fff","height":"16rpx"},
				options2: {
					effect: 'flip',
					loop : true
				},
				options3: {
					effect: 'cube',
					loop : true,
					cubeEffect: {
						shadow: true,
						slideShadows: true,
						shadowOffset: 20,
						shadowScale: 0.94,
					}
				},
				rows: 2,
				column: 4,
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
				role : '',
				aboutUsDetail: {},
				menuList: [],
				swiperMenuList:[],
				user: {},
				tableName:'',
				menuColor: '#409eff,#67c23a,#909399,#e6a23c,#f56c6c,#356c6c,#351c6c,#f093a9,#a7c23a,#104eff,#10441f,#a21233,#503319'.split(','),

				//轮播
				swiperList: [],
				homezhiyuanhuodonglist: [],
				news: [],
				scrollTop: 0,
			}
		},
		onPageScroll(e) {
			this.scrollTop = e.scrollTop
		},
		watch: {
		},
		mounted() {
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onLoad(){
			this.menuColor = this.menuColor.sort(()=> {
				return (0.5-Math.random());
			});
		},
		async onShow() {
			if (this.timerList4&&this.timerList4!=null) clearInterval(this.timerList4)
			this.swiperMenuList = []
			this.role = uni.getStorageSync("appRole");
			let table = uni.getStorageSync("nowTable");
			let res = {}
			if(table) {
				res = await this.$api.session(table);
				this.user = res.data;
				this.tableName = table;
			}
			let menus = menu.list();
			this.menuList = menus;
			this.menuList.forEach((item,key) => {
				if(key==0) {
					item.frontMenu.forEach((item2,key2) => {
						if(item2.child[0].buttons.indexOf("查看")>-1) {
							this.swiperMenuList.push(item2);
						}
					})
				}
			})
			// let res;
			// 轮播图
			let swiperList = []
			res = await this.$api.list('config', {
				page: 1,
				limit: 5
			});
			for (let item of res.data.list) {
				if (item.name.indexOf('picture') >= 0 && item.value && item.value!="" && item.value!=null ) {
					swiperList.push({
						img: item.value,
						title: item.name,
						url: item.url
					});
				}
			}
			if (swiperList) {
				this.swiperList = swiperList;
			}
			
			this.prevNumList4 = this.swiperList.length - 1
			this.timerList4 = setInterval(this.autoPlayList4, 3000)

			this.getAboutUs();
			this.getRecommendList()
			this.getHomeList()
			this.getNewsList()
		},
		methods: {
			scrollTopClick(){
				uni.pageScrollTo({
					scrollTop: 0
				})
			},
			uGetRect(selector, all) {
				return new Promise(resolve => {
					uni.createSelectorQuery()
					.in(this)
					[all ? 'selectAll' : 'select'](selector)
					.boundingClientRect(rect => {
						if (all && Array.isArray(rect) && rect.length) {
							resolve(rect);
						}
						if (!all && rect) {
							resolve(rect);
						}
					})
					.exec();
				});
			},
			cloneData(data) {
				return JSON.parse(JSON.stringify(data));
			},
			newsTabClick2(index){
				this.newsIndex2 = index
				this.getNewsList()
			},
			async getNewsList(){
				let res;
				let params = {
					page: 1,
					limit: 6,
					sort: 'id',
					order: 'desc',
				}
				// 公告栏
				res = await this.$api.list('news', params)
				this.news = res.data.list
			},
			homeTabClick2(index,name){
				this['home' + name + 'Index2'] = index
				this.getHomeList()
			},
			async getHomeList(){
				let res;
				let params;
				params = {
					page:1,
					limit: 6,
					sort: 'fabushijian',
					order: 'desc',
				}
				res = await this.$api.list('zhiyuanhuodong', params);
				this.homezhiyuanhuodonglist = res.data.list
			},
			recommendTabClick2(index,name){
				this[name + 'Index2'] = index
				this.getRecommendList()
			},
			async getRecommendList(){
				let res;
				let params;
			},
			autoPlayList4() {
				this.prevNumList4 = this.numList4
			
				this.numList4++
				if (this.numList4 == this.swiperList.length) this.numList4 = 0
			},
			touchStart(event) {
				this.startX = event.touches[0].clientX
				
				clearInterval(this.timerList4)
				this.flagList4 = true
			},
			touchMove(event) {
				const currentX = event.touches[0].clientX;
				const deltaX = currentX - this.startX;
				
				if (deltaX > 50) {
					// 向右滑动逻辑
					if (this.flagList4) {
						this.flagList4 = false
						
						this.prevNumList4 = this.numList4
						this.numList4++
						if (this.numList4 == this.swiperList.length) this.numList4 = 0
					}
					
				} else if (deltaX < -50) {
					// 向左滑动逻辑
					if (this.flagList4) {
						this.flagList4 = false
						
						this.prevNumList4 = this.numList4
						this.numList4--
						if (this.numList4 < 0) this.numList4 = this.swiperList.length - 1
					}
				}
			},
			touchEnd() {
				this.startX = 0
				this.timerList4 = setInterval(this.autoPlayList4, 3000)
				this.flagList4 = false
			},
			//轮播图跳转
			onSwiperTap(e) {
				if(e.url) {
					if (e.url.indexOf('https') != -1) {
						// #ifdef MP-WEIXIN
						uni.navigateTo({
						    url: '../../common/linkOthers/linkOthers?url=' + encodeURIComponent(e.url),
						});
						return false
						// #endif
						window.open(e.url)
					} else {
						this.$utils.jump(e.url)
					}
				}
			},
			async getAboutUs() {
				let res = await this.$api.info('aboutus', 1)
				this.aboutUsDetail = res.data;
			},
			// 新闻详情
			onNewsDetailTap(id) {
				this.$utils.jump(`../news-detail/news-detail?id=${id}`)
			},
			// 推荐列表点击详情
			onDetailTap(tableName, id) {
				this.$utils.jump(`../${tableName}/detail?id=${id}`)
			},
			onPageTap(tableName){
				uni.navigateTo({
					url: `../${tableName}/list`,
					fail: function(){
						uni.switchTab({
							url: `../${tableName}/list`
						});
					}
				});
				// this.$utils.jump(`../${tableName}/list`)
			},
			onPageTap2(index) {
				let url = '../' + index + '/list'
				uni.setStorageSync("useridTag",0);
				uni.navigateTo({
					url: url,
					fail: function() {
						uni.switchTab({
							url: url
						});
					}
				});
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	.list-swiper-4 .animate__animated {
		--animate-delay: 300ms;
	}

	.menu_view {
		padding: 0;
		margin: 0;
		background: none;
		display: flex;
		width: 100%;
		justify-content: space-between;
		flex-wrap: wrap;
		height: auto;
		.menu-item {
			border-radius: 8rpx;
			padding: 12rpx 0;
			margin: 10rpx 0;
			width: 23%;
			height: auto;
			.iconarr {
				border-radius: 100%;
				padding: 0;
				margin: 0px auto;
				color: #fff;
				background: none;
				display: block;
				width: 80rpx;
				font-size: 80rpx;
				line-height: 80rpx;
				height: 80rpx;
			}
			.text {
				padding: 0;
				margin: 12rpx auto 0;
				color: #333;
				width: 100%;
				font-size: 28rpx;
				line-height: 28rpx;
				text-align: center;
			}
		}
	}
</style>
