package com.ztgeo.pointtopoint.utils;

import com.ztgeo.pointtopoint.controller.entity.*;
import com.ztgeo.pointtopoint.handle.entity.*;
import org.apache.commons.lang3.StringUtils;

/**
 * 字典
 */
public class Dict {
    /**
     * 抵押不动产类型
     *
     * @param dybdclx
     * @return
     */
    public static String changeDYBDCLX(String dybdclx) {
        if (StringUtils.isBlank(dybdclx)) {
            dybdclx = "";
        } else if ("土地".equals(dybdclx) || "宗地".equals(dybdclx)) {
            dybdclx = "1";
        } else if ("土地和房屋".equals(dybdclx) || "房屋".equals(dybdclx) || "多幢房屋".equals(dybdclx) || "房屋、宗地".equals(dybdclx)
                || "宗地、房屋".equals(dybdclx)) {
            dybdclx = "2";
        } else if ("土地和房屋".equals(dybdclx)) {
            dybdclx = "2";
        } else if ("林地和林木".equals(dybdclx)) {
            dybdclx = "3";
        } else if ("土地和在建建筑物".equals(dybdclx)) {
            dybdclx = "4";
        } else if ("海域".equals(dybdclx)) {
            dybdclx = "5";
        } else if ("海域和构筑物".equals(dybdclx)) {
            dybdclx = "6";
        } else if ("其它".equals(dybdclx) || "厂房".equals(dybdclx)) {
            dybdclx = "7";
        } else {
            if ("1".equals(dybdclx) || "2".equals(dybdclx) || "3".equals(dybdclx) || "4".equals(dybdclx) || "5".equals(dybdclx) || "6".equals(dybdclx) || "7".equals(dybdclx)) {
                return dybdclx;
            } else {
                dybdclx = "";//转义失败 传空串
            }
        }
        return dybdclx;
    }

    /**
     * 房屋类型 约束条件O
     *
     * @param fwlx
     * @return
     */
    public static String changeFWLX(String fwlx) {

        if (StringUtils.isBlank(fwlx)) {
            fwlx = "";
        } else if ("住宅".equals(fwlx)) {
            fwlx = "1";
        } else if ("商业用房".equals(fwlx)) {
            fwlx = "2";
        } else if ("办公用房".equals(fwlx)) {
            fwlx = "3";
        } else if ("工业用房".equals(fwlx)) {
            fwlx = "4";
        } else if ("仓储用房".equals(fwlx)) {
            fwlx = "5";
        } else if ("车库".equals(fwlx)) {
            fwlx = "6";
        } else if ("其它".equals(fwlx)) {
            fwlx = "99";
        } else {
            if ("1".equals(fwlx) || "2".equals(fwlx) || "3".equals(fwlx) || "4".equals(fwlx) || "5".equals(fwlx) || "6".equals(fwlx) || "99".equals(fwlx)) {
                return fwlx;
            } else {
                fwlx = null;//转义失败 可以不传
            }
        }
        return fwlx;
    }

    /**
     * 面积单位
     *
     * @param mjdw
     * @return
     */
    public static String changeMJDW(String mjdw) {
        if (StringUtils.isBlank(mjdw)) {
            mjdw = "";
        } else if ("平方米".equals(mjdw)) {
            mjdw = "1";
        } else if ("亩".equals(mjdw)) {
            mjdw = "2";
        } else if ("公顷".equals(mjdw)) {
            mjdw = "3";
        } else {
            if ("1".equals(mjdw) || "2".equals(mjdw) || "3".equals(mjdw)) {
                return mjdw;
            } else {
                return "";
            }
        }
        return mjdw;
    }

    /**
     * 房屋结构
     *
     * @param fwjg
     * @return
     */
    public static String changeFWJG(String fwjg) {
        if (StringUtils.isBlank(fwjg)) {
            fwjg = null; //原来为“” 点对点约束为O 可以不传
        } else if ("钢结构".equals(fwjg)) {
            fwjg = "1";
        } else if ("钢和钢筋混凝土结构".equals(fwjg)) {
            fwjg = "2";
        } else if ("钢筋混凝土结构".equals(fwjg)) {
            fwjg = "3";
        } else if ("混合结构".equals(fwjg)) {
            fwjg = "4";
        } else if ("砖木结构".equals(fwjg)) {
            fwjg = "5";
        } else if ("其它结构".equals(fwjg)) {
            fwjg = "6";
        } else {
            if ("1".equals(fwjg) || "2".equals(fwjg) || "3".equals(fwjg) || "4".equals(fwjg) || "5".equals(fwjg) || "6".equals(fwjg)) {
                return fwjg;
            } else {
                fwjg = null;//转义失败 可以不传
            }
        }
        return fwjg;
    }

    /**
     * 共有方式 约束条件M
     *
     * @param gyfs
     * @return
     */
    public static String changeGYFS(String gyfs) {
        if (StringUtils.isBlank(gyfs)) {
            gyfs = "";
        } else if ("单独所有".equals(gyfs)) {
            gyfs = "0";
        } else if ("共同共有".equals(gyfs)) {
            gyfs = "1";
        } else if ("按份共有".equals(gyfs)) {
            gyfs = "2";
        } else if ("其他共有".equals(gyfs)) {
            gyfs = "3";
        } else {
            if ("0".equals(gyfs) || "1".equals(gyfs) || "2".equals(gyfs) || "3".equals(gyfs)) {
                return gyfs;
            } else {
                gyfs = "";//约束条件为M 转义失败 使用空串
            }
        }
        return gyfs;
    }

    /**
     * 房屋性质
     *
     * @param fwxz
     * @return
     */
    public static String changeFWXZ(String fwxz) {
        if (StringUtils.isBlank(fwxz)) {
            fwxz = null; //原来为“” 点对点约束为O 可以不传
        } else if ("市场化商品房".equals(fwxz)) {
            fwxz = "0";
        } else if ("动迁房".equals(fwxz)) {
            fwxz = "1";
        } else if ("配套商品房".equals(fwxz)) {
            fwxz = "2";
        } else if ("公共租赁住房".equals(fwxz)) {
            fwxz = "3";
        } else if ("廉租住房".equals(fwxz)) {
            fwxz = "4";
        } else if ("限价普通商品住房".equals(fwxz)) {
            fwxz = "5";
        } else if ("经济适用住房".equals(fwxz)) {
            fwxz = "6";
        } else if ("定销商品房".equals(fwxz)) {
            fwxz = "7";
        } else if ("集资建房".equals(fwxz)) {
            fwxz = "8";
        } else if ("福利房".equals(fwxz)) {
            fwxz = "9";
        } else if ("其它".equals(fwxz)) {
            fwxz = "99";
        } else {
            if ("0".equals(fwxz) || "1".equals(fwxz) || "2".equals(fwxz) || "3".equals(fwxz) || "4".equals(fwxz) || "5".equals(fwxz) || "6".equals(fwxz) || "7".equals(fwxz) || "8".equals(fwxz) || "9".equals(fwxz) || "99".equals(fwxz)) {
                return fwxz;
            } else {
                fwxz = null;//转义失败 可以不传
            }
        }
        return fwxz;
    }

    /**
     * 规划用途
     *
     * @param ghyt
     * @return
     */
    public static String changeGHYT(String ghyt) {
        if (StringUtils.isBlank(ghyt)) {
            ghyt = null; //原来为“” 点对点约束为O 可以不传
        } else if ("住宅".equals(ghyt) || "360".equals(ghyt)) {
            ghyt = "10";
        } else if ("成套住宅".equals(ghyt)) {
            ghyt = "11";
        } else if ("别墅".equals(ghyt)) {
            ghyt = "111";
        } else if ("高档公寓".equals(ghyt)) {
            ghyt = "112";
        } else if ("非成套住宅".equals(ghyt)) {
            ghyt = "12";
        } else if ("集体宿舍".equals(ghyt)) {
            ghyt = "13";
        } else if ("工业、交通、仓储".equals(ghyt)) {
            ghyt = "20";
        } else if ("工业".equals(ghyt)) {
            ghyt = "21";
        } else if ("公共设施".equals(ghyt)) {
            ghyt = "22";
        } else if ("铁路".equals(ghyt)) {
            ghyt = "23";
        } else if ("民航".equals(ghyt)) {
            ghyt = "24";
        } else if ("航运".equals(ghyt)) {
            ghyt = "25";
        } else if ("公共运输".equals(ghyt)) {
            ghyt = "26";
        } else if ("仓储".equals(ghyt)) {
            ghyt = "27";
        } else if ("商业、金融、信息".equals(ghyt) || "370".equals(ghyt)) {
            ghyt = "30";
        } else if ("商业服务".equals(ghyt)) {
            ghyt = "31";
        } else if ("经营".equals(ghyt)) {
            ghyt = "32";
        } else if ("旅游".equals(ghyt)) {
            ghyt = "33";
        } else if ("金融保险".equals(ghyt)) {
            ghyt = "34";
        } else if ("电讯信息".equals(ghyt)) {
            ghyt = "35";
        } else if ("教育、医疗、卫生、科研".equals(ghyt)) {
            ghyt = "40";
        } else if ("教育".equals(ghyt)) {
            ghyt = "41";
        } else if ("医疗卫生".equals(ghyt)) {
            ghyt = "42";
        } else if ("科研".equals(ghyt)) {
            ghyt = "43";
        } else if ("文化、娱乐、体育".equals(ghyt)) {
            ghyt = "50";
        } else if ("文化".equals(ghyt)) {
            ghyt = "51";
        } else if ("新闻".equals(ghyt)) {
            ghyt = "52";
        } else if ("娱乐".equals(ghyt)) {
            ghyt = "53";
        } else if ("园林绿化".equals(ghyt)) {
            ghyt = "54";
        } else if ("体育".equals(ghyt)) {
            ghyt = "55";
        } else if ("办公".equals(ghyt)) {
            ghyt = "60";
        } else if ("军事".equals(ghyt)) {
            ghyt = "70";
        } else if ("其它".equals(ghyt)) {
            ghyt = "80";
        } else if ("涉外".equals(ghyt)) {
            ghyt = "81";
        } else if ("宗教".equals(ghyt)) {
            ghyt = "82";
        } else if ("监狱".equals(ghyt)) {
            ghyt = "83";
        } else if ("物管用房".equals(ghyt)) {
            ghyt = "84";
        } else if ("车位".equals(ghyt)) {
            ghyt = "85";
        } else {
            if ("10".equals(ghyt) || "11".equals(ghyt) || "10".equals(ghyt) || "111".equals(ghyt) || "112".equals(ghyt) || "12".equals(ghyt) || "13".equals(ghyt) || "20".equals(ghyt) || "21".equals(ghyt) || "22".equals(ghyt) || "23".equals(ghyt) || "24".equals(ghyt) || "25".equals(ghyt) || "26".equals(ghyt) || "27".equals(ghyt) || "30".equals(ghyt) || "31".equals(ghyt) || "32".equals(ghyt) || "33".equals(ghyt) || "34".equals(ghyt) || "35".equals(ghyt) || "40".equals(ghyt) || "41".equals(ghyt) || "42".equals(ghyt) || "43".equals(ghyt) || "50".equals(ghyt) || "51".equals(ghyt) || "52".equals(ghyt) || "53".equals(ghyt) || "54".equals(ghyt) || "55".equals(ghyt) || "60".equals(ghyt) || "70".equals(ghyt) || "80".equals(ghyt) || "81".equals(ghyt) || "82".equals(ghyt) || "83".equals(ghyt) || "84".equals(ghyt) || "85".equals(ghyt)) {
                return ghyt;
            } else {
                ghyt = null;//转义失败 可以不传
            }

        }

        //在所有的转换都不起作用的时候 如何处理？？ 应该赋值给其它 防止没有发生转换！！
        return ghyt;
    }

    /**
     * 抵押方式 约束条件M
     *
     * @param dyfs
     * @return
     */
    public static String changeDYFS(String dyfs) {
        if (StringUtils.isBlank(dyfs)) {
            dyfs = "";
        } else if ("一般抵押".equals(dyfs)) {
            dyfs = "1";
        } else if ("最高额抵押".equals(dyfs)) {
            dyfs = "2";
        } else {
            if ("1".equals(dyfs) || "2".equals(dyfs)) {
                return dyfs;
            } else {
                return ""; //字典转义失败
            }
        }
        return dyfs;
    }

    /**
     * 查封类型
     *
     * @param cflx
     * @return
     */
    public static String changeCFLX(String cflx) {

        if (StringUtils.isBlank(cflx)) {
            cflx = "";
        } else if ("查封".equals(cflx) || "按证查封".equals(cflx)) {
            cflx = "1";
        } else if ("轮候查封".equals(cflx) || "续查封".equals(cflx)) {
            cflx = "2";
        } else if ("预查封".equals(cflx)) {
            cflx = "3";
        } else if ("轮候预查封".equals(cflx)) {
            cflx = "4";
        } else {
            if ("1".equals(cflx) || "2".equals(cflx) || "3".equals(cflx) || "4".equals(cflx)) {
                return cflx;
            } else {
                cflx = "";//转义失败 空串
            }
        }

        return cflx;
    }


    /**
     * 用途 约束条件为O 可以不传
     *
     * @param yt
     * @return
     */
    public static String changeYT(String yt) {
        if (StringUtils.isBlank(yt)) {
            yt = null;
        } else if ("耕地".equals(yt)) {
            yt = "01";
        } else if ("水田".equals(yt)) {
            yt = "011";
        } else if ("水浇地".equals(yt)) {
            yt = "012";
        } else if ("旱地".equals(yt)) {
            yt = "013";
        } else if ("园地".equals(yt)) {
            yt = "02";
        } else if ("果园".equals(yt)) {
            yt = "021";
        } else if ("茶园".equals(yt)) {
            yt = "022";
        } else if ("其他园地".equals(yt)) {
            yt = "023";
        } else if ("林地".equals(yt)) {
            yt = "03";
        } else if ("有林地".equals(yt)) {
            yt = "031";
        } else if ("灌木林地".equals(yt)) {
            yt = "032";
        } else if ("其他林地".equals(yt)) {
            yt = "033";
        } else if ("草地".equals(yt)) {
            yt = "04";
        } else if ("天然牧草地".equals(yt)) {
            yt = "041";
        } else if ("人工牧草地".equals(yt)) {
            yt = "042";
        } else if ("其他草地".equals(yt)) {
            yt = "043";
        } else if ("商服用地".equals(yt)) {
            yt = "05";
        } else if ("批发零售用地".equals(yt)) {
            yt = "051";
        } else if ("住宿餐饮用地".equals(yt)) {
            yt = "052";
        } else if ("商务金融用地".equals(yt)) {
            yt = "053";
        } else if ("其他商服用地".equals(yt)) {
            yt = "054";
        } else if ("工矿仓储用地".equals(yt)) {
            yt = "06";
        } else if ("工业用地".equals(yt)) {
            yt = "061";
        } else if ("采矿用地".equals(yt)) {
            yt = "062";
        } else if ("仓储用地".equals(yt)) {
            yt = "063";
        } else if ("住宅用地".equals(yt)) {
            yt = "07";
        } else if ("城镇住宅用地".equals(yt)) {
            yt = "071";
        } else if ("农村宅基地".equals(yt)) {
            yt = "072";
        } else if ("公共管理与公共服务用地".equals(yt)) {
            yt = "08";
        } else if ("机关团体用地".equals(yt)) {
            yt = "081";
        } else if ("新闻出版用地".equals(yt)) {
            yt = "082";
        } else if ("科教用地".equals(yt)) {
            yt = "083";
        } else if ("医卫慈善用地".equals(yt)) {
            yt = "084";
        } else if ("文体娱乐用地".equals(yt)) {
            yt = "085";
        } else if ("公共设施用地".equals(yt)) {
            yt = "086";
        } else if ("公园与绿地".equals(yt)) {
            yt = "087";
        } else if ("风景名胜设施用地".equals(yt)) {
            yt = "088";
        } else if ("特殊用地".equals(yt)) {
            yt = "09";
        } else if ("军事设施用地".equals(yt)) {
            yt = "091";
        } else if ("使领馆用地".equals(yt)) {
            yt = "092";
        } else if ("监教场所用地".equals(yt)) {
            yt = "093";
        } else if ("宗教用地".equals(yt)) {
            yt = "094";
        } else if ("殡葬用地".equals(yt)) {
            yt = "095";
        } else if ("交通运输用地".equals(yt)) {
            yt = "10";
        } else if ("铁路用地".equals(yt)) {
            yt = "101";
        } else if ("公路用地".equals(yt)) {
            yt = "102";
        } else if ("街巷用地".equals(yt)) {
            yt = "103";
        } else if ("农村道路".equals(yt)) {
            yt = "104";
        } else if ("机场用地".equals(yt)) {
            yt = "105";
        } else if ("港口码头用地".equals(yt)) {
            yt = "106";
        } else if ("管道运输用地".equals(yt)) {
            yt = "107";
        } else if ("水域及水利设施用地".equals(yt)) {
            yt = "11";
        } else if ("河流水面".equals(yt)) {
            yt = "111";
        } else if ("湖泊水面".equals(yt)) {
            yt = "112";
        } else if ("水库水面".equals(yt)) {
            yt = "113";
        } else if ("坑塘水面".equals(yt)) {
            yt = "114";
        } else if ("沿海滩涂".equals(yt)) {
            yt = "115";
        } else if ("内陆滩涂".equals(yt)) {
            yt = "116";
        } else if ("沟渠".equals(yt)) {
            yt = "117";
        } else if ("水工建筑用地".equals(yt)) {
            yt = "118";
        } else if ("冰川及永久积雪".equals(yt)) {
            yt = "119";
        } else if ("其他土地".equals(yt)) {
            yt = "12";
        } else if ("空闲地".equals(yt)) {
            yt = "121";
        } else if ("设施农用地".equals(yt)) {
            yt = "122";
        } else if ("田坎".equals(yt)) {
            yt = "123";
        } else if ("盐碱地".equals(yt)) {
            yt = "124";
        } else if ("沼泽地".equals(yt)) {
            yt = "125";
        } else if ("沙地".equals(yt)) {
            yt = "126";
        } else if ("裸地".equals(yt)) {
            yt = "127";
        } else {
            if ("01".equals(yt) || "011".equals(yt) || "012".equals(yt) || "013".equals(yt) || "02".equals(yt) || "021".equals(yt) || "022".equals(yt) || "023".equals(yt) || "03".equals(yt) || "031".equals(yt) || "032".equals(yt) || "033".equals(yt) || "04".equals(yt) ||
                    "041".equals(yt) || "042".equals(yt) || "043".equals(yt) || "05".equals(yt) || "051".equals(yt) || "052".equals(yt) || "053".equals(yt) || "054".equals(yt) || "06".equals(yt) || "061".equals(yt) || "062".equals(yt) || "063".equals(yt) || "07".equals(yt) ||
                    "071".equals(yt) || "072".equals(yt) || "08".equals(yt) || "081".equals(yt) || "082".equals(yt) || "083".equals(yt) || "084".equals(yt) || "085".equals(yt) || "086".equals(yt) || "087".equals(yt) || "088".equals(yt) || "09".equals(yt) || "091".equals(yt) || "092".equals(yt) || "093".equals(yt) || "094".equals(yt) || "095".equals(yt) || "10".equals(yt) || "101".equals(yt) || "102".equals(yt) || "103".equals(yt) || "104".equals(yt)
                    || "105".equals(yt) || "106".equals(yt) || "107".equals(yt) || "11".equals(yt) || "111".equals(yt) || "112".equals(yt) || "113".equals(yt) || "114".equals(yt) || "115".equals(yt) || "116".equals(yt) || "117".equals(yt) || "118".equals(yt) || "119".equals(yt)
                    || "12".equals(yt) || "121".equals(yt) || "122".equals(yt) || "123".equals(yt) || "124".equals(yt) || "125".equals(yt) || "126".equals(yt) || "127".equals(yt)) {
                return yt;
            } else {
                return null;//转义失败 可以不传
            }
        }
        return yt;
    }

    /**
     * 权力性质 约束类型为O
     *
     * @param qlxz
     * @return
     */
    public static String changeQLXZ(String qlxz) {
        if (StringUtils.isBlank(qlxz)) {
            qlxz = null;
        } else if ("国有土地".equals(qlxz)) {
            qlxz = "100";
        } else if ("划拨".equals(qlxz)) {
            qlxz = "101";
        } else if ("出让".equals(qlxz)) {
            qlxz = "102";
        } else if ("作价出资（入股）".equals(qlxz)) {
            qlxz = "103";
        } else if ("国有土地租赁".equals(qlxz)) {
            qlxz = "104";
        } else if ("授权经营".equals(qlxz)) {
            qlxz = "105";
        } else if ("家庭承包".equals(qlxz)) {
            qlxz = "106";
        } else if ("其它方式承包".equals(qlxz)) {
            qlxz = "107";
        } else if ("集体土地".equals(qlxz)) {
            qlxz = "200";
        } else if ("其它方式承包".equals(qlxz)) {
            qlxz = "202";
        } else if ("批准拨用".equals(qlxz)) {
            qlxz = "203";
        } else if ("入股".equals(qlxz)) {
            qlxz = "204";
        } else if ("联营".equals(qlxz)) {
            qlxz = "205";
        } else {
            if ("100".equals(qlxz) || "101".equals(qlxz) || "102".equals(qlxz) || "103".equals(qlxz) || "104".equals(qlxz) || "105".equals(qlxz) || "106".equals(qlxz) || "107".equals(qlxz) || "200".equals(qlxz) || "201".equals(qlxz) || "202".equals(qlxz) || "203".equals(qlxz) || "204".equals(qlxz) || "205".equals(qlxz)) {
                return qlxz;
            } else {
                qlxz = null;//转义失败 可以不传
            }
        }
        return qlxz;
    }

    /**
     * 预告登记种类 约束条件为M
     *
     * @param ygdjzl
     * @return
     */
    public static String changeYGDJZL(String ygdjzl) {
        if (StringUtils.isBlank(ygdjzl)) {
            ygdjzl = "";
        } else if ("预售商品房买卖预告登记".equals(ygdjzl)) {
            ygdjzl = "1";
        } else if ("其它不动产买卖预告登记".equals(ygdjzl)) {
            ygdjzl = "2";
        } else if ("预售商品房抵押权预告登记".equals(ygdjzl)) {
            ygdjzl = "3";
        } else if ("其它不动产抵押权预告登记".equals(ygdjzl)) {
            ygdjzl = "4";
        } else {
            if ("1".equals(ygdjzl) || "2".equals(ygdjzl) || "3".equals(ygdjzl) || "4".equals(ygdjzl)) {
                return ygdjzl;
            } else {
                ygdjzl = "";//转义失败 传空串
            }
        }
        return ygdjzl;
    }

    /**
     * 证件种类 约束条件M
     *
     * @param zjzl
     * @return
     */
    public static String changeZJZL(String zjzl) {
        if (StringUtils.isBlank(zjzl)) {
            return "";
        } else if ("身份证".equals(zjzl)) {
            return "1";
        } else if ("港澳台身份证".equals(zjzl)) {
            return "2";
        } else if ("护照".equals(zjzl)) {
            return "3";
        } else if ("户口簿".equals(zjzl)) {
            return "4";
        } else if ("军官证（士兵证）".equals(zjzl) || "军官证(士兵证)".equals(zjzl) || "军官证".equals(zjzl) || "士兵证".equals(zjzl)) {
            return "5";
        } else if ("组织机构代码".equals(zjzl)) {
            return "6";
        } else if ("营业执照".equals(zjzl)) {
            return "7";
        } else if ("统一社会信用代码".equals(zjzl)) {
            return "8";
        } else if ("其它".equals(zjzl)) {
            return "99";
        } else {
            if ("1".equals(zjzl) || "2".equals(zjzl) || "3".equals(zjzl) || "4".equals(zjzl) || "5".equals(zjzl) || "6".equals(zjzl) || "7".equals(zjzl) || "8".equals(zjzl) || "99".equals(zjzl)) {
                return zjzl;
            } else {
                return "99";//证件种类可以适当使用其他 这边应该不会带来相应的问题
            }
        }
    }

    /**
     * 权力类型 约束种类 M
     *
     * @param qllx
     * @return
     */
    public static String changeQLLX(String qllx) {
        if (StringUtils.isBlank(qllx)) {
            qllx = "";
        } else if ("集体土地所有权".equals(qllx)) {
            qllx = "1";
        } else if ("国家土地所有权".equals(qllx)) {
            qllx = "2";
        } else if ("国有建设用地使用权".equals(qllx)) {
            qllx = "3";
        } else if ("国有建设用地使用权/房屋所有权".equals(qllx)) {
            qllx = "4";
        } else if ("宅基地使用权".equals(qllx)) {
            qllx = "5";
        } else if ("宅基地使用权/房屋所有权".equals(qllx)) {
            qllx = "6";
        } else if ("集体建设用地使用权".equals(qllx)) {
            qllx = "7";
        } else if ("集体建设用地使用权/房屋所有权".equals(qllx)) {
            qllx = "8";
        } else if ("土地承包经营权".equals(qllx)) {
            qllx = "9";
        } else if ("土地承包经营权/森林、林木所有权".equals(qllx)) {
            qllx = "10";
        } else if ("林地使用权".equals(qllx)) {
            qllx = "11";
        } else if ("林地使用权/森林、林木使用权".equals(qllx)) {
            qllx = "12";
        } else if ("草原使用权".equals(qllx)) {
            qllx = "13";
        } else if ("水域滩涂养殖权".equals(qllx)) {
            qllx = "14";
        } else if ("海域使用权".equals(qllx)) {
            qllx = "15";
        } else if ("海域使用权/构筑物所有权".equals(qllx)) {
            qllx = "16";
        } else if ("无居民海岛使用权".equals(qllx)) {
            qllx = "17";
        } else if ("无居民海岛使用权/构筑物所有权".equals(qllx)) {
            qllx = "18";
        } else if ("地役权".equals(qllx)) {
            qllx = "19";
        } else if ("取水权".equals(qllx)) {
            qllx = "20";
        } else if ("探矿权".equals(qllx)) {
            qllx = "21";
        } else if ("采矿权".equals(qllx)) {
            qllx = "22";
        } else if ("国有农用地使用权".equals(qllx)) {
            qllx = "23";
        } else if ("国有建设用地使用权/构筑物所有权".equals(qllx)) {
            qllx = "24";
        } else if ("宅基地使用权/构筑物所有权".equals(qllx)) {
            qllx = "25";
        } else if ("集体建设用地使用权/构筑物所有权".equals(qllx)) {
            qllx = "26";
        } else if ("海域使用权/建筑物所有权".equals(qllx)) {
            qllx = "27";
        } else if ("无居民海岛使用权/建筑物所有权".equals(qllx)) {
            qllx = "28";
        } else if ("其它权利".equals(qllx)) {
            qllx = "99";
        } else {
            if ("1".equals(qllx) || "2".equals(qllx) || "3".equals(qllx) || "4".equals(qllx) || "5".equals(qllx) || "6".equals(qllx) || "7".equals(qllx) || "8".equals(qllx) || "9".equals(qllx) || "10".equals(qllx) || "11".equals(qllx) || "12".equals(qllx) || "13".equals(qllx) ||
                    "14".equals(qllx) || "15".equals(qllx) || "16".equals(qllx) || "17".equals(qllx) || "18".equals(qllx) || "19".equals(qllx) || "20".equals(qllx) || "21".equals(qllx) || "22".equals(qllx) || "23".equals(qllx) || "24".equals(qllx) || "25".equals(qllx) || "26".equals(qllx) ||
                    "27".equals(qllx) || "28".equals(qllx) || "99".equals(qllx)) {
                return qllx;
            } else {
                qllx = "";//转义失败 使用空串
            }
        }
        return qllx;
    }

    /**
     * 查询机构标识字典，未启用
     *
     * @param cxjgbs
     * @return
     */
    public static String changeCXJGBS(String cxjgbs) {
        if (StringUtils.isBlank(cxjgbs)) {
            cxjgbs = "";
        } else if ("tax".equals(cxjgbs)) {
            cxjgbs = "地税";
        } else if ("court".equals(cxjgbs)) {
            cxjgbs = "省高院";
        } else if ("supremecourt".equals(cxjgbs)) {
            cxjgbs = "最高院";
        } else if ("police".equals(cxjgbs)) {
            cxjgbs = "公安";
        } else if ("civil".equals(cxjgbs)) {
            cxjgbs = "民政";
        } else if ("bank".equals(cxjgbs)) {
            cxjgbs = "银行";
        } else if ("sac".equals(cxjgbs)) {
            cxjgbs = "社会救助中心";
        } else if ("supervision".equals(cxjgbs)) {
            cxjgbs = "监察委";
        } else if ("commerce".equals(cxjgbs)) {
            cxjgbs = "工商";
        } else if ("naturalResources".equals(cxjgbs)) {
            cxjgbs = "自然资源部";
        }
        return cxjgbs;
    }

    /**
     * 查询业务类别
     *
     * @param cxywlb
     * @return
     */
    public static String changeCXYWLB(String cxywlb) {
        if (StringUtils.isBlank(cxywlb)) {
            cxywlb = "";
        } else if ("bdc".equals(cxywlb)) {
            cxywlb = "不动产查询业务";
        } else if ("civil".equals(cxywlb)) {
            cxywlb = "民政部门婚姻信息查询业务";
        } else if ("social".equals(cxywlb)) {
            cxywlb = "民政部门社会组织查询业务";
        } else if ("id-apply".equals(cxywlb)) {
            cxywlb = "公安部门居民身份信息查询申请业务";
        } else if ("id-response".equals(cxywlb)) {
            cxywlb = "公安部门居民身份信息查询申请反馈业务";
        } else if ("bdc-realTimeQuery".equals(cxywlb)) {
            cxywlb = "市县不动产登记机构网络直接查询业务";
        }
        return cxywlb;
    }

    /**
     * 反馈code
     *
     * @param code
     * @return
     */


    public static String getResultCode(String code) {
        if (code.equals("0000")) {
            code = "成功";
        } else if (code.equals("1001")) {
            code = "查询条件为空";
        } else if (code.equals("1002")) {
            code = "查询条件格式错误";
        } else if (code.equals("1003")) {
            code = "查询结果已反馈至相关部门";
        } else if (code.equals("2001")) {
            code = "用户名密码验证错误";
        } else if (code.equals("2002")) {
            code = "安全 token 错误";
        } else if (code.equals("2003")) {
            code = "查询权限错误";
        } else if (code.equals("2004")) {
            code = "查询业务类别错误";
        } else if (code.equals("2005")) {
            code = "查询结果不规范";
        } else if (code.equals("2006")) {
            code = "查询申请单号错误";
        } else if (code.equals("2007")) {
            code = "查询数据超过 10 条";
        } else if (code.equals("2008")) {
            code = "文书编号错误";
        } else if (code.equals("2009")) {
            code = "获取 token 依据错误";
        } else if (code.equals("2010")) {
            code = "查询文书不存在";
        } else if (code.equals("2011")) {
            code = "相关部门服务异常";
        } else if (code.equals("2013")) {
            code = "申请单号结果已经被领取";
        } else if (code.equals("2014")) {
            code = "文件不应大于 5M!";
        } else if (code.equals("2015")) {
            code = "承办人名称为空";
        } else if (code.equals("2016")) {
            code = "该请求无对应文书";
        } else if (code.equals("2019")) {
            code = "参数格式错误或者不完整，请检查";
        } else if (code.equals("2020")) {
            code = "OpenId 不合法";
        } else if (code.equals("3001")) {
            code = "查询结果不存在";
        } else if (code.equals("3002")) {
            code = "部分查询单号反馈失败";
        } else if (code.equals("3004")) {
            code = "ES 中没有数据";
        } else if (code.equals("3005")) {
            code = "查询参数中文书重复异常";
        } else if (code.equals("3006")) {
            code = "查询结果尚未反馈";
        } else if (code.equals("3009")) {
            code = "机构业务类别关系不存在";
        } else if (code.equals("3011")) {
            code = "机构字段关系不存在";
        } else if (code.equals("3012")) {
            code = "申请单号:反馈结果不全";
        } else if (code.equals("3013")) {
            code = "获取民政 token 异常";
        } else if (code.equals("3014")) {
            code = "入参参数有误";
        } else if (code.equals("9001")) {
            code = "系统错误";
        } else if (code.equals("9002")) {
            code = "还未从江苏省公安厅人口库查询\n" +
                    "此居民信息，请稍后再发起查询";
        } else if (code.equals("9003")) {
            code = "未收到此居民身份证号查询请求";
        } else if (code.equals("9004")) {
            code = "江苏省公安厅人口库未查询到此\n" +
                    "人";
        } else if (code.equals("failure")) {
//            code = "java.sql.BatchUpdateException";
            code = "省厅内部错误";
        } else if (code.equals("null")) {
            code = " 接收到的反馈结果为空";
        }
        return code;
    }


    public DirectTDSYQ tdsyqConversion(DirectTDSYQ tdsyq) {
        String bdcdyh = tdsyq.getBdcdyh() == null ? "" : tdsyq.getBdcdyh();
        String zl = tdsyq.getZl() == null ? "" : tdsyq.getZl();
        String zdmj = tdsyq.getZdmj() == null ? "" : tdsyq.getZdmj();
        String mjdw = tdsyq.getMjdw() == null ? "" : tdsyq.getMjdw();
        String yt = tdsyq.getYt() == null ? "" : tdsyq.getYt();
        String qlxz = tdsyq.getQlxz() == null ? "" : tdsyq.getQlxz();
        String bdcqzh = tdsyq.getBdcqzh() == null ? "" : tdsyq.getBdcqzh();
        String djjg = tdsyq.getDjjg() == null ? "" : tdsyq.getDjjg();
        String djsj = tdsyq.getDjsj() == null ? "" : tdsyq.getDjsj();
        String gyfs = tdsyq.getGyfs() == null ? "" : tdsyq.getGyfs();
        String gyr = tdsyq.getGyr() == null ? "" : tdsyq.getGyr();
        String gyqk = tdsyq.getGyqk() == null ? "" : tdsyq.getGyqk();
        String qszt = tdsyq.getQszt() == null ? "" : tdsyq.getQszt();
        String ywh = tdsyq.getYwh() == null ? "" : tdsyq.getYwh();
        String qlrdh = tdsyq.getQlrdh() == null ? "" : tdsyq.getQlrdh();
        String qxdm = tdsyq.getQxdm() == null ? "" : tdsyq.getQxdm();
        String qllx = tdsyq.getQllx() == null ? "" : tdsyq.getQllx();
        String sfdy = tdsyq.getSfdy() == null ? "" : tdsyq.getSfdy();
        String sfcf = tdsyq.getSfcf() == null ? "" : tdsyq.getSfcf();
        return new DirectTDSYQ(bdcdyh, zl, zdmj, mjdw, yt, qlxz, bdcqzh, djjg, djsj, gyfs, gyr, gyqk, qszt, ywh, qlrdh, qxdm, qllx, sfdy, sfcf);
    }

    public DirectFDCQ fdcqConversion(DirectFDCQ directFDCQ) {
        String bdcdyh = directFDCQ.getBdcdyh() == null ? "" : directFDCQ.getBdcdyh();
        String fdzl = directFDCQ.getFdzl() == null ? "" : directFDCQ.getFdzl();
        String jzmj = directFDCQ.getJzmj() == null ? "" : directFDCQ.getJzmj();
        String ghyt = directFDCQ.getGhyt() == null ? "" : directFDCQ.getGhyt();
        String fwxz = directFDCQ.getFwxz() == null ? "" : directFDCQ.getFwxz();
        String jgsj = directFDCQ.getJgsj() == null ? "" : directFDCQ.getJgsj();
        String tdsyqssj = directFDCQ.getTdsyqssj() == null ? "" : directFDCQ.getTdsyqssj();
        String tdsyjssj = directFDCQ.getTdsyjssj() == null ? "" : directFDCQ.getTdsyjssj();
        String bdcqzh = directFDCQ.getBdcqzh() == null ? "" : directFDCQ.getBdcqzh();
        String djjg = directFDCQ.getDjjg() == null ? "" : directFDCQ.getDjjg();
        String zyjzmj = directFDCQ.getZyjzmj() == null ? "" : directFDCQ.getZyjzmj();
        String ftjzmj = directFDCQ.getFtjzmj() == null ? "" : directFDCQ.getFtjzmj();
        String djsj = directFDCQ.getDjsj() == null ? "" : directFDCQ.getDjsj();
        String gyfs = directFDCQ.getGyfs() == null ? "" : directFDCQ.getGyfs();
        String fdcjyjg = directFDCQ.getFdcjyjg() == null ? "" : directFDCQ.getFdcjyjg();
        String fwjg = directFDCQ.getFwjg() == null ? "" : directFDCQ.getFwjg();
        String fwlx = directFDCQ.getFwlx() == null ? "" : directFDCQ.getFwlx();
        String gyr = directFDCQ.getGyr() == null ? "" : directFDCQ.getGyr();
        String gyqk = directFDCQ.getGyqk() == null ? "" : directFDCQ.getGyqk();
        String qszt = directFDCQ.getQszt() == null ? "" : directFDCQ.getQszt();
        String ywh = directFDCQ.getYwh() == null ? "" : directFDCQ.getYwh();
        String qlrdh = directFDCQ.getQlrdh() == null ? "" : directFDCQ.getQlrdh();
        String qxdm = directFDCQ.getQxdm() == null ? "" : directFDCQ.getQxdm();
        String qllx = directFDCQ.getQllx() == null ? "" : directFDCQ.getQllx();
        String sfdy = directFDCQ.getSfdy() == null ? "" : directFDCQ.getSfdy();
        String sfcf = directFDCQ.getSfcf() == null ? "" : directFDCQ.getSfcf();
        String tdqlxz = directFDCQ.getTdqlxz() == null ? "" : directFDCQ.getTdqlxz();
        String tdsyqr = directFDCQ.getTdsyqr() == null ? "" : directFDCQ.getTdsyqr();
        String dytdmj = directFDCQ.getDytdmj() == null ? "" : directFDCQ.getDytdmj();
        String fttdmj = directFDCQ.getFttdmj() == null ? "" : directFDCQ.getFttdmj();
        return new DirectFDCQ(bdcdyh, fdzl, jzmj, ghyt, fwxz, jgsj, tdsyqssj, tdsyjssj, bdcqzh, djjg, zyjzmj, ftjzmj, djsj, gyfs, fdcjyjg, fwjg, fwlx, gyr, gyqk, qszt, ywh, qlrdh, qxdm, qllx, sfdy, sfcf, tdqlxz, tdsyqr, dytdmj, fttdmj);
    }

    public DirectGJZWSYQ gjzwsyqConversion(DirectGJZWSYQ directGJZWSYQ) {
        String bdcdyh = directGJZWSYQ.getBdcdyh() == null ? "" : directGJZWSYQ.getBdcdyh();
        String zl = directGJZWSYQ.getZl() == null ? "" : directGJZWSYQ.getZl();
        String gjzwghyt = directGJZWSYQ.getGjzwghyt() == null ? "" : directGJZWSYQ.getGjzwghyt();
        String gjzwmj = directGJZWSYQ.getGjzwmj() == null ? "" : directGJZWSYQ.getGjzwmj();
        String tdhysyqssj = directGJZWSYQ.getTdhysyqssj() == null ? "" : directGJZWSYQ.getTdhysyqssj();
        String tdhysyjssj = directGJZWSYQ.getTdhysyjssj() == null ? "" : directGJZWSYQ.getTdhysyjssj();
        String bdcqzh = directGJZWSYQ.getBdcqzh() == null ? "" : directGJZWSYQ.getBdcqzh();
        String djjg = directGJZWSYQ.getDjjg() == null ? "" : directGJZWSYQ.getDjjg();
        String djsj = directGJZWSYQ.getDjsj() == null ? "" : directGJZWSYQ.getDjsj();
        String gyfs = directGJZWSYQ.getGyfs() == null ? "" : directGJZWSYQ.getGyfs();
        String gyr = directGJZWSYQ.getGyr() == null ? "" : directGJZWSYQ.getGyr();
        String gyqk = directGJZWSYQ.getGyqk() == null ? "" : directGJZWSYQ.getGyqk();
        String qszt = directGJZWSYQ.getQszt() == null ? "" : directGJZWSYQ.getQszt();
        String ywh = directGJZWSYQ.getYwh() == null ? "" : directGJZWSYQ.getYwh();
        String qlrdh = directGJZWSYQ.getQlrdh() == null ? "" : directGJZWSYQ.getQlrdh();
        String qxdm = directGJZWSYQ.getQxdm() == null ? "" : directGJZWSYQ.getQxdm();
        String gjzwlx = directGJZWSYQ.getGjzwlx() == null ? "" : directGJZWSYQ.getGjzwlx();
        String qllx = directGJZWSYQ.getQllx() == null ? "" : directGJZWSYQ.getQllx();
        String sfdy = directGJZWSYQ.getSfdy() == null ? "" : directGJZWSYQ.getSfdy();
        String sfcf = directGJZWSYQ.getSfcf() == null ? "" : directGJZWSYQ.getSfcf();
        String tdhysyqr = directGJZWSYQ.getTdhysyqr() == null ? "" : directGJZWSYQ.getTdhysyqr();
        String tdhysymj = directGJZWSYQ.getTdhysymj() == null ? "" : directGJZWSYQ.getTdhysymj();
        return new DirectGJZWSYQ(bdcdyh, zl, gjzwghyt, gjzwmj, tdhysyqssj, tdhysyjssj, bdcqzh, djjg, djsj, gyfs, gyr, gyqk, qszt, ywh, qlrdh, qxdm, gjzwlx, qllx, sfdy, sfcf, tdhysyqr, tdhysymj);
    }

    public DirectDYAQ dyaqConversion(DirectDYAQ directDYAQ) {
        String bdcdyh = directDYAQ.getBdcdyh() == null ? "" : directDYAQ.getBdcdyh();
        String dybdclx = directDYAQ.getDybdclx() == null ? "" : directDYAQ.getDybdclx();
        String zl = directDYAQ.getZl() == null ? "" : directDYAQ.getZl();
        String dyr = directDYAQ.getDyr() == null ? "" : directDYAQ.getDyr();
        String dyfs = directDYAQ.getDyfs() == null ? "" : directDYAQ.getDyfs();
        String bdbzzqse = directDYAQ.getBdbzzqse() == null ? "" : directDYAQ.getBdbzzqse();
        String zwlxqssj = directDYAQ.getZwlxqssj() == null ? "" : directDYAQ.getZwlxqssj();
        String zwlxjssj = directDYAQ.getZwlxjssj() == null ? "" : directDYAQ.getZwlxjssj();
        String bdcdjzmh = directDYAQ.getBdcdjzmh() == null ? "" : directDYAQ.getBdcdjzmh();
        String djjg = directDYAQ.getDjjg() == null ? "" : directDYAQ.getDjjg();
        String djsj = directDYAQ.getDjsj() == null ? "" : directDYAQ.getDjsj();
        String dyqr = directDYAQ.getDyqr() == null ? "" : directDYAQ.getDyqr();
        String zxsj = directDYAQ.getZxsj() == null ? "" : directDYAQ.getZxsj();
        String ywh = directDYAQ.getYwh() == null ? "" : directDYAQ.getYwh();
        String qszt = directDYAQ.getQszt() == null ? "" : directDYAQ.getQszt();
        String qxdm = directDYAQ.getQxdm() == null ? "" : directDYAQ.getQxdm();
        String zjjzwzl = directDYAQ.getZjjzwzl() == null ? "" : directDYAQ.getZjjzwzl();
        String zjjzwdyfw = directDYAQ.getZjjzwdyfw() == null ? "" : directDYAQ.getZjjzwdyfw();
        String zgzqse = directDYAQ.getZgzqse() == null ? "" : directDYAQ.getZgzqse();
        return new DirectDYAQ(bdcdyh, dybdclx, zl, dyr, dyfs, bdbzzqse, zwlxqssj, zwlxjssj, bdcdjzmh, djjg, djsj, dyqr, zxsj, ywh, qszt, qxdm, zjjzwzl, zjjzwdyfw, zgzqse);
    }

    public DirectYGDJ ygdjConversion(DirectYGDJ directYGDJ) {
        String bdcdyh = directYGDJ.getBdcdyh() == null ? "" : directYGDJ.getBdcdyh();
        String ygdjzl = directYGDJ.getYgdjzl() == null ? "" : directYGDJ.getYgdjzl();
        String zl = directYGDJ.getZl() == null ? "" : directYGDJ.getZl();
        String ghyt = directYGDJ.getGhyt() == null ? "" : directYGDJ.getGhyt();
        String jzmj = directYGDJ.getJzmj() == null ? "" : directYGDJ.getJzmj();
        String bdcdjzmh = directYGDJ.getBdcdjzmh() == null ? "" : directYGDJ.getBdcdjzmh();
        String djjg = directYGDJ.getDjjg() == null ? "" : directYGDJ.getDjjg();
        String djsj = directYGDJ.getDjsj() == null ? "" : directYGDJ.getDjsj();
        String zxsj = directYGDJ.getZxsj() == null ? "" : directYGDJ.getZxsj();
        String ywh = directYGDJ.getYwh() == null ? "" : directYGDJ.getYwh();
        String qszt = directYGDJ.getQszt() == null ? "" : directYGDJ.getQszt();
        String qlrdh = directYGDJ.getQlrdh() == null ? "" : directYGDJ.getQlrdh();
        String qxdm = directYGDJ.getQxdm() == null ? "" : directYGDJ.getQxdm();
        String gyfs = directYGDJ.getGyfs() == null ? "" : directYGDJ.getGyfs();
        String gyr = directYGDJ.getGyr() == null ? "" : directYGDJ.getGyr();
        String gyqk = directYGDJ.getGyqk() == null ? "" : directYGDJ.getGyqk();
        String ywr = directYGDJ.getYwr() == null ? "" : directYGDJ.getYwr();
        String ywrzjzl = directYGDJ.getYwrzjzl() == null ? "" : directYGDJ.getYwrzjzl();
        String ywrzjh = directYGDJ.getYwrzjh() == null ? "" : directYGDJ.getYwrzjh();
        String tdsyqr = directYGDJ.getTdsyqr() == null ? "" : directYGDJ.getTdsyqr();
        String fwxz = directYGDJ.getFwxz() == null ? "" : directYGDJ.getFwxz();
        String fwjg = directYGDJ.getFwjg() == null ? "" : directYGDJ.getFwjg();
        String qdjg = directYGDJ.getQdjg() == null ? "" : directYGDJ.getQdjg();
        return new DirectYGDJ(bdcdyh, ygdjzl, zl, ghyt, jzmj, bdcdjzmh, djjg, djsj, zxsj, ywh, qszt, qlrdh, qxdm, gyfs, gyr, gyqk, ywr, ywrzjzl, ywrzjh, tdsyqr, fwxz, fwjg, qdjg);
    }

    public DirectCFDJ cfdjConversion(DirectCFDJ directCFDJ) {
        String bdcdyh = directCFDJ.getBdcdyh() == null ? "" : directCFDJ.getBdcdyh();
        String zl = directCFDJ.getZl() == null ? "" : directCFDJ.getZl();
        String cfjg = directCFDJ.getCfjg() == null ? "" : directCFDJ.getCfjg();
        String cflx = directCFDJ.getCflx() == null ? "" : directCFDJ.getCflx();
        String cfwh = directCFDJ.getCfwh() == null ? "" : directCFDJ.getCfwh();
        String cfqssj = directCFDJ.getCfqssj() == null ? "" : directCFDJ.getCfqssj();
        String cfjssj = directCFDJ.getCfjssj() == null ? "" : directCFDJ.getCfjssj();
        String djjg = directCFDJ.getDjjg() == null ? "" : directCFDJ.getDjjg();
        int xh = directCFDJ.getXh();
        String djsj = directCFDJ.getDjsj() == null ? "" : directCFDJ.getDjsj();
        String jfdjsj = directCFDJ.getJfdjsj() == null ? "" : directCFDJ.getJfdjsj();
        String ywh = directCFDJ.getYwh() == null ? "" : directCFDJ.getYwh();
        String qszt = directCFDJ.getQszt() == null ? "" : directCFDJ.getQszt();
        String qxdm = directCFDJ.getQxdm() == null ? "" : directCFDJ.getQxdm();
        String cffw = directCFDJ.getCffw() == null ? "" : directCFDJ.getCffw();
        String jfwh = directCFDJ.getJfwh() == null ? "" : directCFDJ.getJfwh();
        return new DirectCFDJ(bdcdyh, zl, cfjg, cflx, cfwh, cfqssj, cfjssj, djjg, xh, djsj, jfdjsj, ywh, qszt, qxdm, cffw, jfwh);
    }

    public DirectYYDJ yydjConversion(DirectYYDJ directYYDJ) {
        String bdcdyh = directYYDJ.getBdcdyh() == null ? "" : directYYDJ.getBdcdyh();
        String zl = directYYDJ.getZl() == null ? "" : directYYDJ.getZl();
        String yysx = directYYDJ.getYysx() == null ? "" : directYYDJ.getYysx();
        String bdcdjzmh = directYYDJ.getBdcdjzmh() == null ? "" : directYYDJ.getBdcdjzmh();
        String djjg = directYYDJ.getDjjg() == null ? "" : directYYDJ.getDjjg();
        String djsj = directYYDJ.getDjsj() == null ? "" : directYYDJ.getDjsj();
        String qszt = directYYDJ.getQszt() == null ? "" : directYYDJ.getQszt();
        String ywh = directYYDJ.getYwh() == null ? "" : directYYDJ.getYwh();
        String zxsj = directYYDJ.getZxsj() == null ? "" : directYYDJ.getZxsj();
        String qxdm = directYYDJ.getQxdm() == null ? "" : directYYDJ.getQxdm();
        return new DirectYYDJ(bdcdyh, zl, yysx, bdcdjzmh, djjg, djsj, qszt, ywh, zxsj, qxdm);
    }
}
