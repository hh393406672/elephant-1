package com.sjhy.platform.client.dto.base;

import java.util.ArrayList;
import java.util.List;

public class PlayChannelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlayChannelExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 渠道玩家信息表
     * 
     * @author HJ
     * 
     * @date 2018-12-06
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNull() {
            addCriterion("channel_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(String value) {
            addCriterion("channel_id =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(String value) {
            addCriterion("channel_id <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(String value) {
            addCriterion("channel_id >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(String value) {
            addCriterion("channel_id >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(String value) {
            addCriterion("channel_id <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(String value) {
            addCriterion("channel_id <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLike(String value) {
            addCriterion("channel_id like", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotLike(String value) {
            addCriterion("channel_id not like", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<String> values) {
            addCriterion("channel_id in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<String> values) {
            addCriterion("channel_id not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(String value1, String value2) {
            addCriterion("channel_id between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(String value1, String value2) {
            addCriterion("channel_id not between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andSubChannelIsNull() {
            addCriterion("sub_channel is null");
            return (Criteria) this;
        }

        public Criteria andSubChannelIsNotNull() {
            addCriterion("sub_channel is not null");
            return (Criteria) this;
        }

        public Criteria andSubChannelEqualTo(Integer value) {
            addCriterion("sub_channel =", value, "subChannel");
            return (Criteria) this;
        }

        public Criteria andSubChannelNotEqualTo(Integer value) {
            addCriterion("sub_channel <>", value, "subChannel");
            return (Criteria) this;
        }

        public Criteria andSubChannelGreaterThan(Integer value) {
            addCriterion("sub_channel >", value, "subChannel");
            return (Criteria) this;
        }

        public Criteria andSubChannelGreaterThanOrEqualTo(Integer value) {
            addCriterion("sub_channel >=", value, "subChannel");
            return (Criteria) this;
        }

        public Criteria andSubChannelLessThan(Integer value) {
            addCriterion("sub_channel <", value, "subChannel");
            return (Criteria) this;
        }

        public Criteria andSubChannelLessThanOrEqualTo(Integer value) {
            addCriterion("sub_channel <=", value, "subChannel");
            return (Criteria) this;
        }

        public Criteria andSubChannelIn(List<Integer> values) {
            addCriterion("sub_channel in", values, "subChannel");
            return (Criteria) this;
        }

        public Criteria andSubChannelNotIn(List<Integer> values) {
            addCriterion("sub_channel not in", values, "subChannel");
            return (Criteria) this;
        }

        public Criteria andSubChannelBetween(Integer value1, Integer value2) {
            addCriterion("sub_channel between", value1, value2, "subChannel");
            return (Criteria) this;
        }

        public Criteria andSubChannelNotBetween(Integer value1, Integer value2) {
            addCriterion("sub_channel not between", value1, value2, "subChannel");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdIsNull() {
            addCriterion("channel_user_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdIsNotNull() {
            addCriterion("channel_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdEqualTo(String value) {
            addCriterion("channel_user_id =", value, "channelUserId");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdNotEqualTo(String value) {
            addCriterion("channel_user_id <>", value, "channelUserId");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdGreaterThan(String value) {
            addCriterion("channel_user_id >", value, "channelUserId");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("channel_user_id >=", value, "channelUserId");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdLessThan(String value) {
            addCriterion("channel_user_id <", value, "channelUserId");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdLessThanOrEqualTo(String value) {
            addCriterion("channel_user_id <=", value, "channelUserId");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdLike(String value) {
            addCriterion("channel_user_id like", value, "channelUserId");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdNotLike(String value) {
            addCriterion("channel_user_id not like", value, "channelUserId");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdIn(List<String> values) {
            addCriterion("channel_user_id in", values, "channelUserId");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdNotIn(List<String> values) {
            addCriterion("channel_user_id not in", values, "channelUserId");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdBetween(String value1, String value2) {
            addCriterion("channel_user_id between", value1, value2, "channelUserId");
            return (Criteria) this;
        }

        public Criteria andChannelUserIdNotBetween(String value1, String value2) {
            addCriterion("channel_user_id not between", value1, value2, "channelUserId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdIsNull() {
            addCriterion("player_id is null");
            return (Criteria) this;
        }

        public Criteria andPlayerIdIsNotNull() {
            addCriterion("player_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlayerIdEqualTo(Long value) {
            addCriterion("player_id =", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdNotEqualTo(Long value) {
            addCriterion("player_id <>", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdGreaterThan(Long value) {
            addCriterion("player_id >", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("player_id >=", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdLessThan(Long value) {
            addCriterion("player_id <", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdLessThanOrEqualTo(Long value) {
            addCriterion("player_id <=", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdIn(List<Long> values) {
            addCriterion("player_id in", values, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdNotIn(List<Long> values) {
            addCriterion("player_id not in", values, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdBetween(Long value1, Long value2) {
            addCriterion("player_id between", value1, value2, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdNotBetween(Long value1, Long value2) {
            addCriterion("player_id not between", value1, value2, "playerId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 渠道玩家信息表
     * 
     * @author HJ
     * 
     * @date 2018-12-06
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}