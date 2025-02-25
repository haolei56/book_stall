/*
Navicat MySQL Data Transfer

Source Server         : 本机Localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : shxx

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-04-20 15:02:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `content` varchar(255) DEFAULT NULL COMMENT '描述',
  `url` varchar(255) DEFAULT NULL COMMENT '图片',
  `user` bigint(255) DEFAULT NULL COMMENT '所属商户',
  `price` double DEFAULT NULL COMMENT '价格',
  `gmtTime` datetime DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='商品信息';

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '牛肉面', '牛肉面', '/cdn//cdn/f4fbbd25-560f-4044-919e-38f3896b9724.jpg', '1', '23', '2018-04-20 13:19:54');
INSERT INTO `product` VALUES ('2', '好吃的', '好吃的好吃的好吃的好吃的', '/cdn//cdn/936e9153-b61f-43d5-8850-269380c4e8a3.jpg', '9', '12', '2018-04-20 14:47:39');
INSERT INTO `product` VALUES ('3', '肉肉肉', '好吃的好吃的好吃的', '/cdn//cdn/d3b0e618-71df-4506-95b0-461bf6e3bf9f.jpg', '9', '21', '2018-04-20 14:47:45');
INSERT INTO `product` VALUES ('4', '面面', '11', '/cdn//cdn/acc06da4-6ebe-4bef-b662-f8dbc6b3c062.jpg', '9', '12', '2018-04-20 14:47:59');
INSERT INTO `product` VALUES ('5', '二人火锅套餐', '非常美味', '/cdn//cdn/94bf3f1d-2011-4ca1-8fe9-5c5827c7a117.jpg', '10', '89', '2018-04-20 14:59:32');
INSERT INTO `product` VALUES ('6', '4人火锅', '好吃得很', '/cdn//cdn/c1e3ad22-ae25-4869-bdb5-8e38f1deda7a.jpg', '10', '178', '2018-04-20 14:59:46');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key` varchar(50) DEFAULT NULL COMMENT 'key',
  `value` varchar(2000) DEFAULT NULL COMMENT 'value',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key` (`key`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统配置信息表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('1', 'CLOUD_STORAGE_CONFIG_KEY', '{\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"aliyunDomain\":\"\",\"aliyunEndPoint\":\"\",\"aliyunPrefix\":\"\",\"qcloudBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qiniuAccessKey\":\"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ\",\"qiniuBucketName\":\"ios-app\",\"qiniuDomain\":\"http://7xqbwh.dl1.z0.glb.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuSecretKey\":\"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV\",\"type\":1}', '0', '云存储配置信息');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', 'admin', '修改密码', 'com.learn.controller.SysUserController.password()', '\"admin\"', '0:0:0:0:0:0:0:1', '2018-04-17 10:10:34');
INSERT INTO `sys_log` VALUES ('2', 'admin', '修改菜单', 'com.learn.controller.SysMenuController.update()', '{\"icon\":\"fa fa-comment-o\",\"menuId\":31,\"name\":\"通知公告\",\"orderNum\":6,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":1,\"url\":\"generator/notice.html\"}', '0:0:0:0:0:0:0:1', '2018-04-17 10:12:20');
INSERT INTO `sys_log` VALUES ('3', 'admin', '删除用户', 'com.learn.controller.SysUserController.delete()', '[1]', '0:0:0:0:0:0:0:1', '2018-04-17 10:18:09');
INSERT INTO `sys_log` VALUES ('4', 'admin', '删除用户', 'com.learn.controller.SysUserController.delete()', '[1]', '0:0:0:0:0:0:0:1', '2018-04-17 10:18:55');
INSERT INTO `sys_log` VALUES ('5', 'admin', '保存角色', 'com.learn.controller.SysRoleController.save()', '{\"menuIdList\":[31,32],\"roleName\":\"学生\"}', '0:0:0:0:0:0:0:1', '2018-04-17 10:26:34');
INSERT INTO `sys_log` VALUES ('6', 'admin', '保存用户', 'com.learn.controller.SysUserController.save()', '{\"roleIdList\":[1],\"status\":1,\"username\":\"小明\"}', '0:0:0:0:0:0:0:1', '2018-04-17 10:30:58');
INSERT INTO `sys_log` VALUES ('7', 'admin', '修改菜单', 'com.learn.controller.SysMenuController.update()', '{\"icon\":\"fa fa-th-list\",\"menuId\":36,\"name\":\"课程选择\",\"orderNum\":6,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":1,\"url\":\"generator/choose.html\"}', '0:0:0:0:0:0:0:1', '2018-04-17 12:36:29');
INSERT INTO `sys_log` VALUES ('8', 'admin', '修改菜单', 'com.learn.controller.SysMenuController.update()', '{\"icon\":\"fa fa-user-circle\",\"menuId\":41,\"name\":\"教师管理\",\"orderNum\":6,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":1,\"url\":\"generator/teacher.html\"}', '0:0:0:0:0:0:0:1', '2018-04-17 12:46:48');
INSERT INTO `sys_log` VALUES ('9', 'admin', '删除菜单', 'com.learn.controller.SysMenuController.delete()', '[38,40,39]', '0:0:0:0:0:0:0:1', '2018-04-17 13:00:47');
INSERT INTO `sys_log` VALUES ('10', 'admin', '修改菜单', 'com.learn.controller.SysMenuController.update()', '{\"icon\":\"fa fa-book\",\"menuId\":46,\"name\":\"教师开课\",\"orderNum\":6,\"parentId\":1,\"parentName\":\"系统管理\",\"type\":1,\"url\":\"generator/teachercourse.html\"}', '0:0:0:0:0:0:0:1', '2018-04-17 13:02:38');
INSERT INTO `sys_log` VALUES ('11', 'admin', '修改菜单', 'com.learn.controller.SysMenuController.update()', '{\"icon\":\"fa fa-book\",\"menuId\":46,\"name\":\"教师开课\",\"orderNum\":6,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":1,\"url\":\"generator/teachercourse.html\"}', '0:0:0:0:0:0:0:1', '2018-04-17 13:02:50');
INSERT INTO `sys_log` VALUES ('12', 'admin', '修改菜单', 'com.learn.controller.SysMenuController.update()', '{\"icon\":\"fa fa-user\",\"menuId\":2,\"name\":\"用户管理\",\"orderNum\":1,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":1,\"url\":\"sys/user.html\"}', '0:0:0:0:0:0:0:1', '2018-04-17 13:04:10');
INSERT INTO `sys_log` VALUES ('13', 'admin', '修改角色', 'com.learn.controller.SysRoleController.update()', '{\"createTime\":1492395994000,\"createUserId\":1,\"menuIdList\":[31,32,36,37,46,47],\"roleId\":1,\"roleName\":\"学生\"}', '0:0:0:0:0:0:0:1', '2018-04-17 13:04:43');
INSERT INTO `sys_log` VALUES ('14', 'admin', '修改角色', 'com.learn.controller.SysRoleController.update()', '{\"createTime\":1492395994000,\"createUserId\":1,\"menuIdList\":[31,32,36,37],\"roleId\":1,\"roleName\":\"学生\"}', '0:0:0:0:0:0:0:1', '2018-04-17 13:24:40');
INSERT INTO `sys_log` VALUES ('15', 'admin', '修改菜单', 'com.learn.controller.SysMenuController.update()', '{\"icon\":\"fa fa-build\",\"menuId\":51,\"name\":\"选课记录\",\"orderNum\":6,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":1,\"url\":\"generator/record.html\"}', '0:0:0:0:0:0:0:1', '2018-04-17 14:40:22');
INSERT INTO `sys_log` VALUES ('16', 'admin', '修改菜单', 'com.learn.controller.SysMenuController.update()', '{\"icon\":\"fa fa-building\",\"menuId\":51,\"name\":\"选课记录\",\"orderNum\":6,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":1,\"url\":\"generator/record.html\"}', '0:0:0:0:0:0:0:1', '2018-04-17 14:41:05');
INSERT INTO `sys_log` VALUES ('17', 'admin', '修改角色', 'com.learn.controller.SysRoleController.update()', '{\"createTime\":1492395994000,\"createUserId\":1,\"menuIdList\":[31,32,36,37,51,52],\"roleId\":1,\"roleName\":\"学生\"}', '0:0:0:0:0:0:0:1', '2018-04-17 14:42:53');
INSERT INTO `sys_log` VALUES ('18', 'admin', '修改菜单', 'com.learn.controller.SysMenuController.update()', '{\"icon\":\"fa fa-building\",\"menuId\":53,\"name\":\"学生选课\",\"orderNum\":6,\"parentId\":1,\"parentName\":\"系统管理\",\"type\":1,\"url\":\"generator/record.html\"}', '0:0:0:0:0:0:0:1', '2018-04-17 15:06:42');
INSERT INTO `sys_log` VALUES ('19', 'admin', '修改菜单', 'com.learn.controller.SysMenuController.update()', '{\"icon\":\"fa fa-building\",\"menuId\":53,\"name\":\"学生选课\",\"orderNum\":6,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":1,\"url\":\"generator/record.html\"}', '0:0:0:0:0:0:0:1', '2018-04-17 15:06:48');
INSERT INTO `sys_log` VALUES ('20', 'admin', '修改菜单', 'com.learn.controller.SysMenuController.update()', '{\"icon\":\"fa fa-building\",\"menuId\":53,\"name\":\"学生选课\",\"orderNum\":6,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":1,\"url\":\"generator/choose-user.html\"}', '0:0:0:0:0:0:0:1', '2018-04-17 15:10:43');
INSERT INTO `sys_log` VALUES ('21', 'admin2', '保存角色', 'com.learn.controller.SysRoleController.save()', '{\"menuIdList\":[],\"roleName\":\"系统管理员\"}', '0:0:0:0:0:0:0:1', '2018-04-17 15:24:04');
INSERT INTO `sys_log` VALUES ('22', 'admin2', '修改角色', 'com.learn.controller.SysRoleController.update()', '{\"createTime\":1492413844000,\"createUserId\":-1,\"menuIdList\":[2,15,16,17,18,31,32,33,34,35,41,42,43,44,45,46,47,48,49,50,53,54],\"roleId\":2,\"roleName\":\"系统管理员\"}', '0:0:0:0:0:0:0:1', '2018-04-17 15:29:39');
INSERT INTO `sys_log` VALUES ('23', 'admin', '保存用户', 'com.learn.controller.SysUserController.save()', '{\"email\":\"36113@qq.com\",\"mobile\":\"13887477411\",\"roleIdList\":[1],\"status\":1,\"username\":\"大明\"}', '0:0:0:0:0:0:0:1', '2018-04-17 21:15:22');
INSERT INTO `sys_log` VALUES ('24', 'admin', '保存用户', 'com.learn.controller.SysUserController.save()', '{\"email\":\"zhangsan@137.com\",\"mobile\":\"18378729881\",\"roleIdList\":[1],\"status\":1,\"username\":\"张三\"}', '0:0:0:0:0:0:0:1', '2018-04-17 21:38:29');
INSERT INTO `sys_log` VALUES ('25', 'admin', '保存用户', 'com.learn.controller.SysUserController.save()', '{\"email\":\"lisi@163.com\",\"mobile\":\"13963651269\",\"roleIdList\":[1],\"status\":1,\"username\":\"李四\"}', '0:0:0:0:0:0:0:1', '2018-04-17 21:38:48');
INSERT INTO `sys_log` VALUES ('26', 'admin2', '修改角色', 'com.learn.controller.SysRoleController.update()', '{\"createTime\":1492413844000,\"createUserId\":-1,\"menuIdList\":[2,15,16,17,18,31,32,33,34,35,41,42,43,44,45,46,47,48,49,50,53,54,60,61,62,63,64],\"roleId\":2,\"roleName\":\"系统管理员\"}', '0:0:0:0:0:0:0:1', '2018-04-17 21:41:35');
INSERT INTO `sys_log` VALUES ('27', 'admin', '删除菜单', 'com.learn.controller.SysMenuController.delete()', '[33,34,35,36,37,41,42,43,44,45]', '0:0:0:0:0:0:0:1', '2018-05-04 17:59:51');
INSERT INTO `sys_log` VALUES ('28', 'admin', '删除菜单', 'com.learn.controller.SysMenuController.delete()', '[46,47,48,49,50,51,52,53,54,60]', '0:0:0:0:0:0:0:1', '2018-05-04 17:59:54');
INSERT INTO `sys_log` VALUES ('29', 'admin', '删除菜单', 'com.learn.controller.SysMenuController.delete()', '[64,63,62,61]', '0:0:0:0:0:0:0:1', '2018-05-04 17:59:58');
INSERT INTO `sys_log` VALUES ('30', 'admin', '删除菜单', 'com.learn.controller.SysMenuController.delete()', '[32,31]', '0:0:0:0:0:0:0:1', '2018-05-04 18:00:02');
INSERT INTO `sys_log` VALUES ('31', 'admin', '修改角色', 'com.learn.controller.SysRoleController.update()', '{\"createTime\":1492413844000,\"createUserId\":-1,\"menuIdList\":[1,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,30,29,28,2,15,16,17,18],\"roleId\":2,\"roleName\":\"系统管理员\"}', '0:0:0:0:0:0:0:1', '2018-05-04 18:01:30');
INSERT INTO `sys_log` VALUES ('32', 'admin', '修改角色', 'com.learn.controller.SysRoleController.update()', '{\"createTime\":1492395994000,\"createUserId\":1,\"menuIdList\":[2,15,16,17,18],\"roleId\":1,\"roleName\":\"普通\"}', '0:0:0:0:0:0:0:1', '2018-05-04 18:01:36');
INSERT INTO `sys_log` VALUES ('33', 'admin', '修改角色', 'com.learn.controller.SysRoleController.update()', '{\"createTime\":1492413844000,\"createUserId\":-1,\"menuIdList\":[2,15,16,17,18],\"roleId\":2,\"roleName\":\"系统管理员\"}', '0:0:0:0:0:0:0:1', '2018-05-04 18:04:19');
INSERT INTO `sys_log` VALUES ('34', 'admin', '修改个人信息', 'com.learn.controller.SysUserController.updateInfo()', '\"13612345678\"', '127.0.0.1', '2018-03-13 18:45:44');
INSERT INTO `sys_log` VALUES ('35', 'admin', '修改个人信息', 'com.learn.controller.SysUserController.updateInfo()', '\"13612345678\"', '127.0.0.1', '2018-03-13 18:46:06');
INSERT INTO `sys_log` VALUES ('36', 'admin', '修改个人信息', 'com.learn.controller.SysUserController.updateInfo()', '\"13612345678\"', '127.0.0.1', '2018-03-13 18:46:10');
INSERT INTO `sys_log` VALUES ('37', 'admin', '修改个人信息', 'com.learn.controller.SysUserController.updateInfo()', '\"13223232323\"', '127.0.0.1', '2018-03-13 18:46:41');
INSERT INTO `sys_log` VALUES ('38', 'admin', '修改个人信息', 'com.learn.controller.SysUserController.updateInfo()', '\"321321\"', '127.0.0.1', '2018-03-13 18:46:45');
INSERT INTO `sys_log` VALUES ('39', 'admin', '修改个人信息', 'com.learn.controller.SysUserController.updateInfo()', '\"321321\"', '127.0.0.1', '2018-03-13 18:46:55');
INSERT INTO `sys_log` VALUES ('40', 'admin', '修改个人信息', 'com.learn.controller.SysUserController.updateInfo()', '\"321321\"', '127.0.0.1', '2018-03-13 18:47:09');
INSERT INTO `sys_log` VALUES ('41', 'admin1', '修改菜单', 'com.learn.controller.SysMenuController.update()', '{\"icon\":\"fa fa-user\",\"menuId\":2,\"name\":\"商户管理\",\"orderNum\":1,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":1,\"url\":\"sys/user.html\"}', '0:0:0:0:0:0:0:1', '2018-04-20 13:01:30');
INSERT INTO `sys_log` VALUES ('42', 'admin1', '保存菜单', 'com.learn.controller.SysMenuController.save()', '{\"name\":\"个人信息\",\"orderNum\":5,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":1,\"url\":\"admin/user.html\"}', '0:0:0:0:0:0:0:1', '2018-04-20 13:38:42');
INSERT INTO `sys_log` VALUES ('43', 'admin1', '修改用户', 'com.learn.controller.SysUserController.update()', '{\"addr\":\"fdasfdas\",\"createTime\":1541905871000,\"email\":\"admin@admin.com\",\"lat\":\"104.135522,30.638314\",\"mobile\":\"13612345678\",\"name\":\"fdasfdasfasd\",\"status\":1,\"userId\":1,\"username\":\"admin1\"}', '0:0:0:0:0:0:0:1', '2018-04-20 13:50:01');
INSERT INTO `sys_log` VALUES ('44', 'admin1', '修改用户', 'com.learn.controller.SysUserController.update()', '{\"addr\":\"fdasfdas\",\"createTime\":1541905871000,\"email\":\"admin@admin.com\",\"lat\":\"104.135522,30.638314\",\"mobile\":\"13612345678\",\"name\":\"fdasfdasfasd\",\"status\":1,\"userId\":1,\"username\":\"admin1\"}', '0:0:0:0:0:0:0:1', '2018-04-20 13:50:19');
INSERT INTO `sys_log` VALUES ('45', 'admin1', '修改角色', 'com.learn.controller.SysRoleController.update()', '{\"createTime\":1523949844000,\"createUserId\":-1,\"menuIdList\":[2,15,16,17,18,65,66,67,68,69],\"roleId\":2,\"roleName\":\"系统管理员\"}', '0:0:0:0:0:0:0:1', '2018-04-20 14:42:41');
INSERT INTO `sys_log` VALUES ('46', 'admin1', '修改角色', 'com.learn.controller.SysRoleController.update()', '{\"createTime\":1523931994000,\"createUserId\":1,\"menuIdList\":[70,65,66,67,68,69],\"roleId\":1,\"roleName\":\"普通\"}', '0:0:0:0:0:0:0:1', '2018-04-20 14:42:46');
INSERT INTO `sys_log` VALUES ('47', 'admin1', '修改角色', 'com.learn.controller.SysRoleController.update()', '{\"createTime\":1523949844000,\"createUserId\":-1,\"menuIdList\":[2,15,16,17,18,65,66,69],\"roleId\":2,\"roleName\":\"系统管理员\"}', '0:0:0:0:0:0:0:1', '2018-04-20 14:42:51');
INSERT INTO `sys_log` VALUES ('48', '黎明', '修改用户', 'com.learn.controller.SysUserController.update()', '{\"addr\":\"朝阳路\",\"createTime\":1524206832000,\"lat\":\"104.114304,30.621021\",\"mobile\":\"19399993231\",\"name\":\"张大鹏火锅\",\"status\":1,\"userId\":9,\"username\":\"黎明\"}', '0:0:0:0:0:0:0:1', '2018-04-20 14:47:27');
INSERT INTO `sys_log` VALUES ('49', 'xiaolong', '修改用户', 'com.learn.controller.SysUserController.update()', '{\"addr\":\"成都锦江区\",\"createTime\":1524207517000,\"lat\":\"104.253003,30.660979\",\"mobile\":\"18939293123\",\"name\":\"小龙火锅\",\"status\":1,\"userId\":10,\"username\":\"xiaolong\"}', '0:0:0:0:0:0:0:1', '2018-04-20 14:59:00');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '系统管理', null, null, '0', 'fa fa-cog', '0');
INSERT INTO `sys_menu` VALUES ('2', '0', '商户管理', 'sys/user.html', null, '1', 'fa fa-user', '1');
INSERT INTO `sys_menu` VALUES ('3', '1', '角色管理', 'sys/role.html', null, '1', 'fa fa-user-secret', '2');
INSERT INTO `sys_menu` VALUES ('4', '1', '菜单管理', 'sys/menu.html', null, '1', 'fa fa-th-list', '3');
INSERT INTO `sys_menu` VALUES ('5', '1', 'SQL监控', 'druid/sql.html', null, '1', 'fa fa-bug', '4');
INSERT INTO `sys_menu` VALUES ('6', '1', '定时任务', 'sys/schedule.html', null, '1', 'fa fa-tasks', '5');
INSERT INTO `sys_menu` VALUES ('7', '6', '查看', null, 'sys:schedule:list,sys:schedule:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('8', '6', '新增', null, 'sys:schedule:save', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('9', '6', '修改', null, 'sys:schedule:update', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('10', '6', '删除', null, 'sys:schedule:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('11', '6', '暂停', null, 'sys:schedule:pause', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('12', '6', '恢复', null, 'sys:schedule:resume', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('13', '6', '立即执行', null, 'sys:schedule:run', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('14', '6', '日志列表', null, 'sys:schedule:log', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('15', '2', '查看', null, 'sys:user:list,sys:user:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('16', '2', '新增', null, 'sys:user:save,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('17', '2', '修改', null, 'sys:user:update,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('18', '2', '删除', null, 'sys:user:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('19', '3', '查看', null, 'sys:role:list,sys:role:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('20', '3', '新增', null, 'sys:role:save,sys:menu:perms', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('21', '3', '修改', null, 'sys:role:update,sys:menu:perms', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('22', '3', '删除', null, 'sys:role:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('23', '4', '查看', null, 'sys:menu:list,sys:menu:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('24', '4', '新增', null, 'sys:menu:save,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('25', '4', '修改', null, 'sys:menu:update,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('26', '4', '删除', null, 'sys:menu:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('27', '1', '参数管理', 'sys/config.html', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', '1', 'fa fa-sun-o', '6');
INSERT INTO `sys_menu` VALUES ('28', '1', '代码生成器', 'sys/generator.html', 'sys:generator:list,sys:generator:code', '1', 'fa fa-rocket', '8');
INSERT INTO `sys_menu` VALUES ('29', '1', '系统日志', 'sys/log.html', 'sys:log:list', '1', 'fa fa-file-text-o', '7');
INSERT INTO `sys_menu` VALUES ('30', '1', '文件上传', 'sys/oss.html', 'sys:oss:all', '1', 'fa fa-file-image-o', '6');
INSERT INTO `sys_menu` VALUES ('65', '0', '商品信息', 'admin/product.html', null, '1', null, '6');
INSERT INTO `sys_menu` VALUES ('66', '65', '查看', null, 'product:list,product:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('67', '65', '新增', null, 'product:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('68', '65', '修改', null, 'product:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('69', '65', '删除', null, 'product:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('70', '0', '个人信息', 'admin/user.html', null, '1', null, '5');

-- ----------------------------
-- Table structure for sys_oss
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss`;
CREATE TABLE `sys_oss` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) DEFAULT NULL COMMENT 'URL地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件上传';

-- ----------------------------
-- Records of sys_oss
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '普通', null, '1', '2018-04-17 10:26:34');
INSERT INTO `sys_role` VALUES ('2', '系统管理员', null, '-1', '2018-04-17 15:24:04');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('118', '1', '70');
INSERT INTO `sys_role_menu` VALUES ('119', '1', '65');
INSERT INTO `sys_role_menu` VALUES ('120', '1', '66');
INSERT INTO `sys_role_menu` VALUES ('121', '1', '67');
INSERT INTO `sys_role_menu` VALUES ('122', '1', '68');
INSERT INTO `sys_role_menu` VALUES ('123', '1', '69');
INSERT INTO `sys_role_menu` VALUES ('124', '2', '2');
INSERT INTO `sys_role_menu` VALUES ('125', '2', '15');
INSERT INTO `sys_role_menu` VALUES ('126', '2', '16');
INSERT INTO `sys_role_menu` VALUES ('127', '2', '17');
INSERT INTO `sys_role_menu` VALUES ('128', '2', '18');
INSERT INTO `sys_role_menu` VALUES ('129', '2', '65');
INSERT INTO `sys_role_menu` VALUES ('130', '2', '66');
INSERT INTO `sys_role_menu` VALUES ('131', '2', '69');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `type` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `lat` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('-1', 'admin', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', 'root@renren.io', '321321', '1', null, '2018-11-11 11:11:11', null, null, null, null);
INSERT INTO `sys_user` VALUES ('1', 'admin1', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', 'admin@admin.com', '13612345678', '1', null, '2018-11-11 11:11:11', null, 'fdasfdasfasd', 'fdasfdas', '104.135522,30.638314');
INSERT INTO `sys_user` VALUES ('8', '123123', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', null, null, '1', null, '2018-05-04 18:03:03', null, null, null, '104.135522,30.638314');
INSERT INTO `sys_user` VALUES ('9', '黎明', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', null, '19399993231', '1', null, '2018-04-20 14:47:12', null, '张大鹏火锅', '朝阳路', '104.114304,30.621021');
INSERT INTO `sys_user` VALUES ('10', 'xiaolong', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', null, '18939293123', '1', null, '2018-04-20 14:58:37', null, '小龙火锅', '成都锦江区', '104.253003,30.660979');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('6', '8', '1');
INSERT INTO `sys_user_role` VALUES ('7', '-1', '2');
INSERT INTO `sys_user_role` VALUES ('8', '9', '1');
INSERT INTO `sys_user_role` VALUES ('9', '10', '1');
