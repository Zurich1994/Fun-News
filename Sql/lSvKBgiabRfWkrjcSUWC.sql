-- phpMyAdmin SQL Dump
-- http://www.phpmyadmin.net
--
-- Generation Time: Jun 27, 2015 at 10:11 AM

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `lSvKBgiabRfWkrjcSUWC`
--

-- --------------------------------------------------------

--
-- Table structure for table `collect_fun`
--

CREATE TABLE IF NOT EXISTS `collect_fun` (
  `co_id` int(10) NOT NULL AUTO_INCREMENT,
  `co_time` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fun_id` int(10) NOT NULL,
  `user_id` int(10) NOT NULL,
  PRIMARY KEY (`co_id`),
  KEY `fun_id` (`fun_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Dumping data for table `collect_fun`
--

INSERT INTO `collect_fun` (`co_id`, `co_time`, `fun_id`, `user_id`) VALUES
(1, NULL, 1, 1),
(2, NULL, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `foc_fun`
--

CREATE TABLE IF NOT EXISTS `foc_fun` (
  `foc_id` int(10) NOT NULL AUTO_INCREMENT,
  `foc_time` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `foc_user_id` int(10) NOT NULL,
  `foc_own_id` int(10) NOT NULL,
  PRIMARY KEY (`foc_id`),
  KEY `foc_fun_ibfk_1` (`foc_user_id`),
  KEY `foc_fun_ibfk_2` (`foc_own_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Dumping data for table `foc_fun`
--

INSERT INTO `foc_fun` (`foc_id`, `foc_time`, `foc_user_id`, `foc_own_id`) VALUES
(1, '10:20', 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `fun_fun`
--

CREATE TABLE IF NOT EXISTS `fun_fun` (
  `fun_id` int(10) NOT NULL AUTO_INCREMENT,
  `fun_content` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `fun_time` datetime DEFAULT NULL,
  `user_id` int(10) NOT NULL,
  `Praise_count` int(40) DEFAULT NULL,
  `Down_count` int(40) DEFAULT NULL,
  `Comment_count` int(40) DEFAULT NULL,
  `fun_sign1` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fun_sign2` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fun_sign3` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Share_count` int(40) DEFAULT NULL,
  `Photo_name` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Video_name` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Sound_name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `series` int(5) DEFAULT NULL,
  PRIMARY KEY (`fun_id`),
  KEY `fun_fun_ibfk_1` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=45 ;

--
-- Dumping data for table `fun_fun`
--

INSERT INTO `fun_fun` (`fun_id`, `fun_content`, `fun_time`, `user_id`, `Praise_count`, `Down_count`, `Comment_count`, `fun_sign1`, `fun_sign2`, `fun_sign3`, `Share_count`, `Photo_name`, `Video_name`, `Sound_name`, `series`) VALUES
(1, '第一条段子', '2015-03-04 10:10:02', 1, 0, 0, 0, NULL, NULL, NULL, 8, NULL, NULL, NULL, 0),
(2, '我的第一条段子', '2015-03-02 10:20:20', 2, 0, 0, 0, NULL, NULL, NULL, 8, NULL, NULL, NULL, 0),
(3, '你好', '2015-02-17 20:10:10', 4, 0, 0, 0, NULL, NULL, NULL, 8, NULL, NULL, NULL, 0),
(4, 'hhhhhhhhhh', '2015-02-17 20:10:15', 3, 0, 0, 0, NULL, NULL, NULL, 9, NULL, NULL, NULL, 0),
(5, '', '2015-03-02 10:20:29', 5, 0, 0, 0, NULL, NULL, NULL, 8, '3.jpg', NULL, NULL, 1),
(6, 'dusahdouaoh', '2015-03-02 10:20:27', 1, 0, 0, 0, NULL, NULL, NULL, 9, '4.jpg', NULL, NULL, 2),
(7, 'afisfsdhhfshfs', '2015-03-02 10:20:23', 2, 0, 0, 0, NULL, NULL, NULL, 8, NULL, NULL, NULL, 0),
(8, '你死啊待会', '2015-03-02 10:20:43', 1, 0, 0, 0, NULL, NULL, NULL, 8, NULL, NULL, NULL, 0),
(10, '父母的世界很小,只装满了我们。我们的世界很大,常忽略了她们。她们经常忘了我们已经长大,就像我们经常忘了她们已经渐渐白发。这个世界上,再也没有任何人,可以像父母一样,爱我们如生命。 愿天下父亲节日快乐,健康长寿！', '2015-06-21 09:58:00', 1, 60, 0, 6, NULL, '0', '0', 104, 'father''s day.jpg', '0', NULL, 2),
(11, '每天转眼球：先顺时针，转速极慢，左上右下，要领是只动眼不动头。向左时目光极力向左，能看多远看多远，但头不动。其它方向亦如此。转动轨道为圆形，不只左上右下4个点。顺时针25次逆时针25次，这时后颈会发胀（不发酸继续转），发胀才有疗效。发胀后揉两分钟。坚持做2月，你的近视就基本好了！', '2015-06-20 01:20:00', 2, 5634, 0, 308, '0', '0', '0', 2407, '1.jpg', '0', NULL, 2),
(12, '#休·杰克曼#最终被证实会加入《#X战警：天启#》！一名为电影制作皮革道具的公司的员工证实：他们正为狼叔赶制电影中金刚狼的特质背包呢。上一部留下的疑问，金刚狼的埃德曼钢爪到底还会回来吗？等明年的天启来解答', '2015-06-21 08:05:00', 3, 505, 0, 40, '0', '0', '0', 179, '2.jpg', '0', NULL, 2),
(13, '不要害怕孤单，因为这个世界上，肯定有一个人，正努力地走向你。——《龙猫》', '2015-06-21 02:15:00', 5, 219, 0, 13, '0', '0', '0', 124, '3.jpg', '0', NULL, 2),
(14, '倒立是ㄧ種強迫症～穿什麼衣服配什麼飲料也是ㄧ種緣份，週六晚上10點看花少是一種剛養成的習慣#花兒與少年#', '2015-05-30 14:02:00', 1, 130073, 0, 1045, '0', '0', '0', 4603, '4,jpg', '0', NULL, 2),
(15, '【真相 | 朝鲜的防MERS新药到底咋回事？】当中东呼吸综合征（MERS）在全世界蔓延之际，朝鲜媒体18日报道，朝鲜最近研制出一种神奇药剂，可以有效防治中东呼吸综合征（MERS）、埃博拉、艾滋病和SARS等“恶性传染病”。真有这么神奇的药剂吗？', '2015-06-20 17:46:00', 1, 63, 0, 27, '0', '0', '0', 45, '5.jpg', '0', NULL, 2),
(16, '#嗯哼大王#长大啦，知道帮我干活儿了。这都不是什么大事儿，大事儿是，明天就是星期六，在新的一集#爸爸回来了#里，我带着大王和亮亮甜馨还有小鹏哥奥利一起去旅游，嗯哼被一位姐姐偷吻了，嗯哼被一位姐姐偷吻了，嗯哼被一位姐姐偷吻了，你们猜是谁干的呢？', '2015-06-05 13:31:00', 1, 103154, 0, 13041, '0', '0', '0', 4555, '6.jpg', '0', NULL, 2),
(17, '甜馨闺女的魔性表情包：我们白着呢！ヽ(●-`Д´-)ノ', '2015-06-20 22:48:00', 1, 2153, NULL, 942, '0', '0', '0', 2141, '7.gif', '0', NULL, 8),
(18, '#你的爸爸是什么类型#我记忆中的父亲是模糊的，我记忆中的父亲是有非常好的耐性，我记忆中的父亲，小时候来看我时，总是带着我最爱吃的糖…我记忆中的父亲当时我不知道如何开口叫他一声爸爸，当我想叫的时候他已经去了天堂。记忆中的模糊而短暂，但情感永远不变。爸爸，迟来的爱', '2015-06-21 11:51:00', 1, 22, NULL, 15, '0', '0', '0', 44, '', '0', NULL, 0),
(19, '', '2015-06-21 10:05:00', 2, 68, 0, 155, '0', '0', '0', 425, '8.jpg', '0', NULL, 1),
(20, '也许对别人是一场猝不及防的打扰，但对你却是一场刻骨铭心的回忆。小时候。', '2015-06-21 10:57:00', 2, 4622, 0, 354, '0', '0', '0', 608, '', '0', NULL, 0),
(21, '#周杰伦英雄联盟#发布会帅气照！[doge]你想与#周杰伦#一起玩LOL吗？', '2015-06-21 10:27:00', 1, 265, 0, 41, '0', '0', '0', 97, '9.jpg', '0', NULL, 2),
(22, '击掌[求关注]', '2015-06-21 00:16:00', 2, 323, 0, 69, '0', '0', '0', 54, '10.gif', '0', NULL, 8),
(23, '【10asia】[#BIGBANG#世界巡演#MADE#将由腾讯视频现场直播]21日,YG公司方面表示，昨天(20日)下午举行了’腾讯视频Live Music & BIGBANG合作新闻发布会’.浙江卫视,东方卫视,CCTV等中国国内50余家媒体到场参加.发布会上GD表示”没有进行太多的宣传就开始了巡演,还得到这么多的关爱非常的感谢.', '2015-06-21 10:23:00', 2, 5014, 0, 622, '0', '0', '0', 1828, '', '0', NULL, 0),
(24, '原来蜗牛是酱紫吃东西的。。。。涨姿势！', '2015-06-21 10:02:00', 1, 689, 0, 320, '0', '0', '0', 1632, '11.gif', '0', NULL, 8),
(25, '上一百堂美学的课，不如让孩子自己在大自然里行走一天；教一百个钟点的建筑设计，不如让学生去触摸几个古老的城市；讲一百次文学写作的技巧，不如让写作者在市场里头弄脏自己的裤脚。玩，可以说是天地之间学问的根本。——龙应台', '2015-06-20 10:40:00', 2, 213, 0, 30, '0', '0', '0', 684, '', '0', NULL, 0),
(26, '', '2015-06-21 13:54:00', 1, 315, NULL, 34, '0', '0', '0', 1376, '0.jpg', '0', NULL, 1),
(27, '渐渐的我开始不喜欢把矫情的话挂在嘴边，不再对喜欢的人说我还在等你，不再对亲密的朋友说我特别珍惜你，不再说舍不得也不说我难过，也不去问他们是否也同样在意着我的感受，我知道或许我会失去很多本该属于我的东西，但我更明白深埋心间的才最珍贵 ，我希望我爱的人会懂。', '2015-04-30 10:02:00', 1, 326, 0, 28, '0', '0', '0', 1786, '', '0', NULL, 0),
(28, '', '2015-06-02 10:03:00', 1, 1059, 0, 121, '0', '0', '0', 930, '13.jpg', '0', NULL, 1),
(29, '', '2015-06-02 21:33:00', 2, 776, 21, 144, '0', '0', '0', 326, '', '1.mp4', NULL, 4),
(30, '许多人知道要做自己，但却忍不住暗自和他人攀比，一看到别人有钱、有名、有成就、有美丽，就会无比嫉妒无比焦虑。事实上，如果洞悉生命，也能了解自己，就能不受他人影响，继续开心前进。这就好似参加运动会，跑百米的人不需挂心比举重的人，不同赛场，完全不需攀比较劲。 安心做自己，就能幸福前行。', '2015-06-08 10:05:00', 2, 405, 0, 41, '0', '0', '0', 400, '', '0', NULL, 0),
(31, '', '2014-12-21 22:43:00', 5, 542, 144, 5111, '0', '0', '0', 244, '', '2.mp4', NULL, 4),
(32, '很大ushduahsudias', '2015-06-24 12:52:13', 1, 21371, 3213, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0),
(34, 'hdaushdhadas', '2015-06-24 12:57:00', 5, 21933, 22, NULL, NULL, NULL, NULL, NULL, '3.jpg', NULL, NULL, 2),
(35, '哈哈哈哈哈哈哈', '2015-06-24 11:00:00', 4, 123, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0),
(36, '123456787656788765678765678', '2015-06-24 13:00:00', 4, 213, 33, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0),
(37, '我是郝俊卿！！！是你爸', '2015-06-24 18:07:00', 1, 123, 212, 324, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0),
(40, '我是郝俊卿，喜欢我的点个赞！快点！', '2015-06-24 20:00:00', 1, 10000, 0, 20000, '搞笑', '火星', '男神', NULL, NULL, NULL, NULL, 0),
(41, '我修改好了下拉刷新 不信你试试', '2015-06-25 07:00:00', 1, 100, 200, 300, NULL, NULL, NULL, 400, NULL, NULL, NULL, 0),
(42, '这是一个gif，你看是吗？', '2015-06-26 06:00:00', 1, 100, 100, 100, NULL, NULL, NULL, 100, '7.gif', NULL, NULL, 8),
(43, '', '2015-06-26 00:00:00', 3, 213, 1, 2, NULL, NULL, NULL, 2, '3.jpg', NULL, '1.mp3', 5),
(44, '这首歌很好听', '2015-06-26 02:00:00', 4, 111, 2, 2, NULL, NULL, NULL, 12, '4.jpg', NULL, '2.mp3', 6);

-- --------------------------------------------------------

--
-- Table structure for table `t_comment`
--

CREATE TABLE IF NOT EXISTS `t_comment` (
  `Comment_id` int(4) NOT NULL,
  `Comment_content` varchar(120) NOT NULL,
  `Comment_time` char(10) NOT NULL,
  `Fun_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`Comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `t_down`
--

CREATE TABLE IF NOT EXISTS `t_down` (
  `Down_id` int(4) NOT NULL,
  `Down_time` int(4) NOT NULL,
  PRIMARY KEY (`Down_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `t_music`
--

CREATE TABLE IF NOT EXISTS `t_music` (
  `Music_id` int(4) NOT NULL,
  `Music_name` varchar(5) NOT NULL,
  PRIMARY KEY (`Music_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `t_praise`
--

CREATE TABLE IF NOT EXISTS `t_praise` (
  `Praise_id` int(10) NOT NULL AUTO_INCREMENT,
  `Praise_time` varchar(45) NOT NULL,
  `Praise_user_id` int(10) DEFAULT NULL,
  `Praise_fun_id` int(10) DEFAULT NULL,
  `Praise_type` int(10) NOT NULL,
  PRIMARY KEY (`Praise_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `t_user_info`
--

CREATE TABLE IF NOT EXISTS `t_user_info` (
  `User_id` int(4) NOT NULL AUTO_INCREMENT,
  `User_name` varchar(20) NOT NULL,
  `User_sex` char(5) DEFAULT NULL,
  `User_password` char(20) NOT NULL,
  `User_introduction` varchar(40) DEFAULT NULL,
  `User_registration` char(10) DEFAULT NULL,
  `Msg_count` int(10) DEFAULT NULL,
  `Fans_count` int(10) DEFAULT NULL,
  `Follow_count` int(10) DEFAULT NULL,
  `User_image` varchar(45) DEFAULT NULL,
  `User_truename` varchar(45) DEFAULT NULL,
  `User_account` varchar(45) NOT NULL,
  PRIMARY KEY (`User_id`),
  KEY `User_id` (`User_id`,`User_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=36 ;

--
-- Dumping data for table `t_user_info`
--

INSERT INTO `t_user_info` (`User_id`, `User_name`, `User_sex`, `User_password`, `User_introduction`, `User_registration`, `Msg_count`, `Fans_count`, `Follow_count`, `User_image`, `User_truename`, `User_account`) VALUES
(1, '郝俊卿', '男', '123', '你好，中国', '2015-4-20', 0, 0, 0, '0.jpg', '郝俊卿', '1234567'),
(2, '田旭', '男', '1234', '你好，哈尔滨', '2015-4-21', 0, 0, 0, '1.jpg', '田旭', '4567891'),
(3, '刘铭鑫', '男', '12', 'ab', '2015-4-25', 0, 0, 0, '2.jpg', '刘铭鑫', '111111'),
(4, '孙宇慧', '女', '1', 'a', '2015-4-30', 0, 0, 0, '3.jpg', '孙宇慧', '222222'),
(5, '李昕', '男', '12345', 'aa', '2015-5-2', 0, 0, 0, '4.jpg', '李昕', '333333'),
(10, 'ALex Hao', NULL, '159357', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '007669'),
(11, '2', NULL, '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '004662'),
(12, 'alex', NULL, '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '004675'),
(13, 'alex', NULL, '123456', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '008174'),
(14, '1', NULL, 's', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '002476'),
(15, 'aaaa', NULL, '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '001266'),
(16, 'ddf', NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '00382'),
(17, 'ddf', NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '004085'),
(18, 'dgf', NULL, '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '009129'),
(19, 'ggg', NULL, '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '003871'),
(20, '123465', NULL, 'qq', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '005387'),
(21, 'ddfb', NULL, '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '00620'),
(22, 'alex', NULL, '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '00837'),
(23, 'alex', NULL, '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '004443'),
(24, 'aaa', NULL, '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '00687'),
(25, 'aassdd', NULL, '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '004615'),
(26, '123', NULL, '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '002472'),
(27, '123', NULL, '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '008070'),
(28, 'a', NULL, 'a', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '007225'),
(29, 'hsaf', NULL, '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '003986'),
(30, 'hsaf', NULL, '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '001732'),
(31, 'alex', NULL, '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '00473'),
(32, 'lmx', NULL, '1235', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '005415'),
(34, 'alex', NULL, '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '00109'),
(35, 'alex', NULL, '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '003920');

-- --------------------------------------------------------

--
-- Table structure for table `user_fun`
--

CREATE TABLE IF NOT EXISTS `user_fun` (
  `u_id` int(10) NOT NULL,
  `u_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `u_password` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `u_truename` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `u_sex` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `u_age` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `u_sign` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `u_head` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `u_account` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user_fun`
--

INSERT INTO `user_fun` (`u_id`, `u_name`, `u_password`, `u_truename`, `u_sex`, `u_age`, `u_sign`, `u_head`, `u_account`) VALUES
(1, '郝俊卿', '123', '郝俊卿', '男', '22', '哈哈', '0.jpg', '12345678'),
(2, '田旭', '1234', '田旭', '男', '21', '哈哈哈', '1.jpg', '45677889');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `collect_fun`
--
ALTER TABLE `collect_fun`
  ADD CONSTRAINT `collect_fun_ibfk_1` FOREIGN KEY (`fun_id`) REFERENCES `fun_fun` (`fun_id`),
  ADD CONSTRAINT `collect_fun_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user_fun` (`u_id`);

--
-- Constraints for table `foc_fun`
--
ALTER TABLE `foc_fun`
  ADD CONSTRAINT `foc_fun_ibfk_2` FOREIGN KEY (`foc_own_id`) REFERENCES `t_user_info` (`User_id`),
  ADD CONSTRAINT `foc_fun_ibfk_1` FOREIGN KEY (`foc_user_id`) REFERENCES `t_user_info` (`User_id`);

--
-- Constraints for table `fun_fun`
--
ALTER TABLE `fun_fun`
  ADD CONSTRAINT `fun_fun_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user_info` (`User_id`);

--
-- Constraints for table `t_down`
--
ALTER TABLE `t_down`
  ADD CONSTRAINT `User_id2` FOREIGN KEY (`Down_id`) REFERENCES `t_user_info` (`User_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
