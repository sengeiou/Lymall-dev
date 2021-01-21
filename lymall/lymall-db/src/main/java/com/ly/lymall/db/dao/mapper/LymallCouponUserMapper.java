package com.ly.lymall.db.dao.mapper;

import com.ly.lymall.db.dao.provider.LymallCouponUserSqlProvider;
import com.ly.lymall.db.domian.LymallCouponUser;
import com.ly.lymall.db.dto.LymallUserCouponDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface LymallCouponUserMapper {
    @Delete({
        "delete from lymall_coupon_user",
        "where coupon_user_id = #{couponUserId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer couponUserId);

    @Insert({
        "insert into lymall_coupon_user (user_id, coupon_id, ",
        "coupon_user_status, coupon_user_used_time, ",
        "coupon_user_start_time, coupon_user_end_time, ",
        "order_id, coupon_user_add_time, ",
        "coupon_user_update_time, coupon_user_deleted)",
        "values (#{userId,jdbcType=INTEGER}, #{couponId,jdbcType=INTEGER}, ",
        "#{couponUserStatus,jdbcType=SMALLINT}, #{couponUserUsedTime,jdbcType=TIMESTAMP}, ",
        "#{couponUserStartTime,jdbcType=TIMESTAMP}, #{couponUserEndTime,jdbcType=TIMESTAMP}, ",
        "#{orderId,jdbcType=INTEGER}, #{couponUserAddTime,jdbcType=TIMESTAMP}, ",
        "#{couponUserUpdateTime,jdbcType=TIMESTAMP}, #{couponUserDeleted,jdbcType=BIT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="couponUserId", before=false, resultType=Integer.class)
    int insert(LymallCouponUser record);

    @InsertProvider(type= LymallCouponUserSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="couponUserId", before=false, resultType=Integer.class)
    int insertSelective(LymallCouponUser record);

    /**
     * 根据用户id添加优惠券
     * @param userCoupon
     * @return int
     */
    @Insert("insert into " +
            "lymall_coupon_user(user_id,coupon_id,coupon_user_start_time,coupon_user_end_time,coupon_user_add_time) " +
            "value(#{userId},#{couponId},#{couponUserStartTime},#{couponUserEndTime},#{couponUserAddTime})")
    int byUserIdAddCouponInfo(LymallCouponUser userCoupon);

    @Select({
        "select",
        "coupon_user_id, user_id, coupon_id, coupon_user_status, coupon_user_used_time, ",
        "coupon_user_start_time, coupon_user_end_time, order_id, coupon_user_add_time, ",
        "coupon_user_update_time, coupon_user_deleted",
        "from lymall_coupon_user",
        "where coupon_user_id = #{couponUserId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="coupon_user_id", property="couponUserId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="coupon_id", property="couponId", jdbcType=JdbcType.INTEGER),
        @Result(column="coupon_user_status", property="couponUserStatus", jdbcType=JdbcType.SMALLINT),
        @Result(column="coupon_user_used_time", property="couponUserUsedTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="coupon_user_start_time", property="couponUserStartTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="coupon_user_end_time", property="couponUserEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER),
        @Result(column="coupon_user_add_time", property="couponUserAddTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="coupon_user_update_time", property="couponUserUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="coupon_user_deleted", property="couponUserDeleted", jdbcType=JdbcType.BIT)
    })
    LymallCouponUser selectByPrimaryKey(Integer couponUserId);

    /**
     * 该方法传入userId与couponId与status时只查询单张优惠券使用情况
     * 传入userId与status时则按状态来查询用户优惠券信息 比如查询该用户所有未使用的优惠券
     * @param userId
     * @param couponId
     * @param status
     * @return List<LymallUserCouponDTO> 集合
     */
    @SelectProvider(type=LymallCouponUserSqlProvider.class,method="selectByUserIdAndCouponIdAndCouponStatus")
    List<LymallUserCouponDTO> selectByUserIdFindAllCouponInfo(Integer userId, Integer couponId, Short status);

    @UpdateProvider(type=LymallCouponUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LymallCouponUser record);

    @Update({
        "update lymall_coupon_user",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "coupon_id = #{couponId,jdbcType=INTEGER},",
          "coupon_user_status = #{couponUserStatus,jdbcType=SMALLINT},",
          "coupon_user_used_time = #{couponUserUsedTime,jdbcType=TIMESTAMP},",
          "coupon_user_start_time = #{couponUserStartTime,jdbcType=TIMESTAMP},",
          "coupon_user_end_time = #{couponUserEndTime,jdbcType=TIMESTAMP},",
          "order_id = #{orderId,jdbcType=INTEGER},",
          "coupon_user_add_time = #{couponUserAddTime,jdbcType=TIMESTAMP},",
          "coupon_user_update_time = #{couponUserUpdateTime,jdbcType=TIMESTAMP},",
          "coupon_user_deleted = #{couponUserDeleted,jdbcType=BIT}",
        "where coupon_user_id = #{couponUserId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(LymallCouponUser record);
}