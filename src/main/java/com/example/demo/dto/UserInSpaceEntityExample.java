package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class UserInSpaceEntityExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table have_user_list
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table have_user_list
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table have_user_list
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table have_user_list
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public UserInSpaceEntityExample() {
		oredCriteria = new ArrayList<>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table have_user_list
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table have_user_list
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table have_user_list
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table have_user_list
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table have_user_list
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table have_user_list
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table have_user_list
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table have_user_list
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table have_user_list
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table have_user_list
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table have_user_list
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<>();
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

		public Criteria andSpaceIdIsNull() {
			addCriterion("space_id is null");
			return (Criteria) this;
		}

		public Criteria andSpaceIdIsNotNull() {
			addCriterion("space_id is not null");
			return (Criteria) this;
		}

		public Criteria andSpaceIdEqualTo(Integer value) {
			addCriterion("space_id =", value, "spaceId");
			return (Criteria) this;
		}

		public Criteria andSpaceIdNotEqualTo(Integer value) {
			addCriterion("space_id <>", value, "spaceId");
			return (Criteria) this;
		}

		public Criteria andSpaceIdGreaterThan(Integer value) {
			addCriterion("space_id >", value, "spaceId");
			return (Criteria) this;
		}

		public Criteria andSpaceIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("space_id >=", value, "spaceId");
			return (Criteria) this;
		}

		public Criteria andSpaceIdLessThan(Integer value) {
			addCriterion("space_id <", value, "spaceId");
			return (Criteria) this;
		}

		public Criteria andSpaceIdLessThanOrEqualTo(Integer value) {
			addCriterion("space_id <=", value, "spaceId");
			return (Criteria) this;
		}

		public Criteria andSpaceIdIn(List<Integer> values) {
			addCriterion("space_id in", values, "spaceId");
			return (Criteria) this;
		}

		public Criteria andSpaceIdNotIn(List<Integer> values) {
			addCriterion("space_id not in", values, "spaceId");
			return (Criteria) this;
		}

		public Criteria andSpaceIdBetween(Integer value1, Integer value2) {
			addCriterion("space_id between", value1, value2, "spaceId");
			return (Criteria) this;
		}

		public Criteria andSpaceIdNotBetween(Integer value1, Integer value2) {
			addCriterion("space_id not between", value1, value2, "spaceId");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNull() {
			addCriterion("user_id is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("user_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(Integer value) {
			addCriterion("user_id =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(Integer value) {
			addCriterion("user_id <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(Integer value) {
			addCriterion("user_id >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("user_id >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(Integer value) {
			addCriterion("user_id <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("user_id <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<Integer> values) {
			addCriterion("user_id in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<Integer> values) {
			addCriterion("user_id not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(Integer value1, Integer value2) {
			addCriterion("user_id between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("user_id not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andAuthorityIdIsNull() {
			addCriterion("authority_id is null");
			return (Criteria) this;
		}

		public Criteria andAuthorityIdIsNotNull() {
			addCriterion("authority_id is not null");
			return (Criteria) this;
		}

		public Criteria andAuthorityIdEqualTo(Integer value) {
			addCriterion("authority_id =", value, "authorityId");
			return (Criteria) this;
		}

		public Criteria andAuthorityIdNotEqualTo(Integer value) {
			addCriterion("authority_id <>", value, "authorityId");
			return (Criteria) this;
		}

		public Criteria andAuthorityIdGreaterThan(Integer value) {
			addCriterion("authority_id >", value, "authorityId");
			return (Criteria) this;
		}

		public Criteria andAuthorityIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("authority_id >=", value, "authorityId");
			return (Criteria) this;
		}

		public Criteria andAuthorityIdLessThan(Integer value) {
			addCriterion("authority_id <", value, "authorityId");
			return (Criteria) this;
		}

		public Criteria andAuthorityIdLessThanOrEqualTo(Integer value) {
			addCriterion("authority_id <=", value, "authorityId");
			return (Criteria) this;
		}

		public Criteria andAuthorityIdIn(List<Integer> values) {
			addCriterion("authority_id in", values, "authorityId");
			return (Criteria) this;
		}

		public Criteria andAuthorityIdNotIn(List<Integer> values) {
			addCriterion("authority_id not in", values, "authorityId");
			return (Criteria) this;
		}

		public Criteria andAuthorityIdBetween(Integer value1, Integer value2) {
			addCriterion("authority_id between", value1, value2, "authorityId");
			return (Criteria) this;
		}

		public Criteria andAuthorityIdNotBetween(Integer value1, Integer value2) {
			addCriterion("authority_id not between", value1, value2, "authorityId");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table have_user_list
	 * @mbg.generated  Fri Apr 30 22:14:58 JST 2021
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table have_user_list
     *
     * @mbg.generated do_not_delete_during_merge Fri Apr 30 22:14:58 JST 2021
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }
}