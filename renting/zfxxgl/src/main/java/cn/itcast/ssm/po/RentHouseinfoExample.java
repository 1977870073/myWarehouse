package cn.itcast.ssm.po;

import java.util.ArrayList;
import java.util.List;

public class RentHouseinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RentHouseinfoExample() {
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

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Integer value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Integer value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Integer value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Integer value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Integer value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Integer> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Integer> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Integer value1, Integer value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceTypeIsNull() {
            addCriterion("price_type is null");
            return (Criteria) this;
        }

        public Criteria andPriceTypeIsNotNull() {
            addCriterion("price_type is not null");
            return (Criteria) this;
        }

        public Criteria andPriceTypeEqualTo(String value) {
            addCriterion("price_type =", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeNotEqualTo(String value) {
            addCriterion("price_type <>", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeGreaterThan(String value) {
            addCriterion("price_type >", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("price_type >=", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeLessThan(String value) {
            addCriterion("price_type <", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeLessThanOrEqualTo(String value) {
            addCriterion("price_type <=", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeLike(String value) {
            addCriterion("price_type like", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeNotLike(String value) {
            addCriterion("price_type not like", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeIn(List<String> values) {
            addCriterion("price_type in", values, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeNotIn(List<String> values) {
            addCriterion("price_type not in", values, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeBetween(String value1, String value2) {
            addCriterion("price_type between", value1, value2, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeNotBetween(String value1, String value2) {
            addCriterion("price_type not between", value1, value2, "priceType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIsNull() {
            addCriterion("house_type is null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIsNotNull() {
            addCriterion("house_type is not null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeEqualTo(String value) {
            addCriterion("house_type =", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotEqualTo(String value) {
            addCriterion("house_type <>", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThan(String value) {
            addCriterion("house_type >", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("house_type >=", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThan(String value) {
            addCriterion("house_type <", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThanOrEqualTo(String value) {
            addCriterion("house_type <=", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLike(String value) {
            addCriterion("house_type like", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotLike(String value) {
            addCriterion("house_type not like", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIn(List<String> values) {
            addCriterion("house_type in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotIn(List<String> values) {
            addCriterion("house_type not in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeBetween(String value1, String value2) {
            addCriterion("house_type between", value1, value2, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotBetween(String value1, String value2) {
            addCriterion("house_type not between", value1, value2, "houseType");
            return (Criteria) this;
        }

        public Criteria andRentalModeIsNull() {
            addCriterion("rental_mode is null");
            return (Criteria) this;
        }

        public Criteria andRentalModeIsNotNull() {
            addCriterion("rental_mode is not null");
            return (Criteria) this;
        }

        public Criteria andRentalModeEqualTo(String value) {
            addCriterion("rental_mode =", value, "rentalMode");
            return (Criteria) this;
        }

        public Criteria andRentalModeNotEqualTo(String value) {
            addCriterion("rental_mode <>", value, "rentalMode");
            return (Criteria) this;
        }

        public Criteria andRentalModeGreaterThan(String value) {
            addCriterion("rental_mode >", value, "rentalMode");
            return (Criteria) this;
        }

        public Criteria andRentalModeGreaterThanOrEqualTo(String value) {
            addCriterion("rental_mode >=", value, "rentalMode");
            return (Criteria) this;
        }

        public Criteria andRentalModeLessThan(String value) {
            addCriterion("rental_mode <", value, "rentalMode");
            return (Criteria) this;
        }

        public Criteria andRentalModeLessThanOrEqualTo(String value) {
            addCriterion("rental_mode <=", value, "rentalMode");
            return (Criteria) this;
        }

        public Criteria andRentalModeLike(String value) {
            addCriterion("rental_mode like", value, "rentalMode");
            return (Criteria) this;
        }

        public Criteria andRentalModeNotLike(String value) {
            addCriterion("rental_mode not like", value, "rentalMode");
            return (Criteria) this;
        }

        public Criteria andRentalModeIn(List<String> values) {
            addCriterion("rental_mode in", values, "rentalMode");
            return (Criteria) this;
        }

        public Criteria andRentalModeNotIn(List<String> values) {
            addCriterion("rental_mode not in", values, "rentalMode");
            return (Criteria) this;
        }

        public Criteria andRentalModeBetween(String value1, String value2) {
            addCriterion("rental_mode between", value1, value2, "rentalMode");
            return (Criteria) this;
        }

        public Criteria andRentalModeNotBetween(String value1, String value2) {
            addCriterion("rental_mode not between", value1, value2, "rentalMode");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(Integer value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(Integer value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(Integer value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(Integer value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(Integer value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(Integer value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<Integer> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<Integer> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(Integer value1, Integer value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(Integer value1, Integer value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andFloorIsNull() {
            addCriterion("floor is null");
            return (Criteria) this;
        }

        public Criteria andFloorIsNotNull() {
            addCriterion("floor is not null");
            return (Criteria) this;
        }

        public Criteria andFloorEqualTo(String value) {
            addCriterion("floor =", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotEqualTo(String value) {
            addCriterion("floor <>", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThan(String value) {
            addCriterion("floor >", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThanOrEqualTo(String value) {
            addCriterion("floor >=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThan(String value) {
            addCriterion("floor <", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThanOrEqualTo(String value) {
            addCriterion("floor <=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLike(String value) {
            addCriterion("floor like", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotLike(String value) {
            addCriterion("floor not like", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorIn(List<String> values) {
            addCriterion("floor in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotIn(List<String> values) {
            addCriterion("floor not in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorBetween(String value1, String value2) {
            addCriterion("floor between", value1, value2, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotBetween(String value1, String value2) {
            addCriterion("floor not between", value1, value2, "floor");
            return (Criteria) this;
        }

        public Criteria andAllfloorIsNull() {
            addCriterion("allfloor is null");
            return (Criteria) this;
        }

        public Criteria andAllfloorIsNotNull() {
            addCriterion("allfloor is not null");
            return (Criteria) this;
        }

        public Criteria andAllfloorEqualTo(Integer value) {
            addCriterion("allfloor =", value, "allfloor");
            return (Criteria) this;
        }

        public Criteria andAllfloorNotEqualTo(Integer value) {
            addCriterion("allfloor <>", value, "allfloor");
            return (Criteria) this;
        }

        public Criteria andAllfloorGreaterThan(Integer value) {
            addCriterion("allfloor >", value, "allfloor");
            return (Criteria) this;
        }

        public Criteria andAllfloorGreaterThanOrEqualTo(Integer value) {
            addCriterion("allfloor >=", value, "allfloor");
            return (Criteria) this;
        }

        public Criteria andAllfloorLessThan(Integer value) {
            addCriterion("allfloor <", value, "allfloor");
            return (Criteria) this;
        }

        public Criteria andAllfloorLessThanOrEqualTo(Integer value) {
            addCriterion("allfloor <=", value, "allfloor");
            return (Criteria) this;
        }

        public Criteria andAllfloorIn(List<Integer> values) {
            addCriterion("allfloor in", values, "allfloor");
            return (Criteria) this;
        }

        public Criteria andAllfloorNotIn(List<Integer> values) {
            addCriterion("allfloor not in", values, "allfloor");
            return (Criteria) this;
        }

        public Criteria andAllfloorBetween(Integer value1, Integer value2) {
            addCriterion("allfloor between", value1, value2, "allfloor");
            return (Criteria) this;
        }

        public Criteria andAllfloorNotBetween(Integer value1, Integer value2) {
            addCriterion("allfloor not between", value1, value2, "allfloor");
            return (Criteria) this;
        }

        public Criteria andOrientationIsNull() {
            addCriterion("orientation is null");
            return (Criteria) this;
        }

        public Criteria andOrientationIsNotNull() {
            addCriterion("orientation is not null");
            return (Criteria) this;
        }

        public Criteria andOrientationEqualTo(String value) {
            addCriterion("orientation =", value, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationNotEqualTo(String value) {
            addCriterion("orientation <>", value, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationGreaterThan(String value) {
            addCriterion("orientation >", value, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationGreaterThanOrEqualTo(String value) {
            addCriterion("orientation >=", value, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationLessThan(String value) {
            addCriterion("orientation <", value, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationLessThanOrEqualTo(String value) {
            addCriterion("orientation <=", value, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationLike(String value) {
            addCriterion("orientation like", value, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationNotLike(String value) {
            addCriterion("orientation not like", value, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationIn(List<String> values) {
            addCriterion("orientation in", values, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationNotIn(List<String> values) {
            addCriterion("orientation not in", values, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationBetween(String value1, String value2) {
            addCriterion("orientation between", value1, value2, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationNotBetween(String value1, String value2) {
            addCriterion("orientation not between", value1, value2, "orientation");
            return (Criteria) this;
        }

        public Criteria andRenovationIsNull() {
            addCriterion("renovation is null");
            return (Criteria) this;
        }

        public Criteria andRenovationIsNotNull() {
            addCriterion("renovation is not null");
            return (Criteria) this;
        }

        public Criteria andRenovationEqualTo(String value) {
            addCriterion("renovation =", value, "renovation");
            return (Criteria) this;
        }

        public Criteria andRenovationNotEqualTo(String value) {
            addCriterion("renovation <>", value, "renovation");
            return (Criteria) this;
        }

        public Criteria andRenovationGreaterThan(String value) {
            addCriterion("renovation >", value, "renovation");
            return (Criteria) this;
        }

        public Criteria andRenovationGreaterThanOrEqualTo(String value) {
            addCriterion("renovation >=", value, "renovation");
            return (Criteria) this;
        }

        public Criteria andRenovationLessThan(String value) {
            addCriterion("renovation <", value, "renovation");
            return (Criteria) this;
        }

        public Criteria andRenovationLessThanOrEqualTo(String value) {
            addCriterion("renovation <=", value, "renovation");
            return (Criteria) this;
        }

        public Criteria andRenovationLike(String value) {
            addCriterion("renovation like", value, "renovation");
            return (Criteria) this;
        }

        public Criteria andRenovationNotLike(String value) {
            addCriterion("renovation not like", value, "renovation");
            return (Criteria) this;
        }

        public Criteria andRenovationIn(List<String> values) {
            addCriterion("renovation in", values, "renovation");
            return (Criteria) this;
        }

        public Criteria andRenovationNotIn(List<String> values) {
            addCriterion("renovation not in", values, "renovation");
            return (Criteria) this;
        }

        public Criteria andRenovationBetween(String value1, String value2) {
            addCriterion("renovation between", value1, value2, "renovation");
            return (Criteria) this;
        }

        public Criteria andRenovationNotBetween(String value1, String value2) {
            addCriterion("renovation not between", value1, value2, "renovation");
            return (Criteria) this;
        }

        public Criteria andResidentialAreasIsNull() {
            addCriterion("residential_areas is null");
            return (Criteria) this;
        }

        public Criteria andResidentialAreasIsNotNull() {
            addCriterion("residential_areas is not null");
            return (Criteria) this;
        }

        public Criteria andResidentialAreasEqualTo(String value) {
            addCriterion("residential_areas =", value, "residentialAreas");
            return (Criteria) this;
        }

        public Criteria andResidentialAreasNotEqualTo(String value) {
            addCriterion("residential_areas <>", value, "residentialAreas");
            return (Criteria) this;
        }

        public Criteria andResidentialAreasGreaterThan(String value) {
            addCriterion("residential_areas >", value, "residentialAreas");
            return (Criteria) this;
        }

        public Criteria andResidentialAreasGreaterThanOrEqualTo(String value) {
            addCriterion("residential_areas >=", value, "residentialAreas");
            return (Criteria) this;
        }

        public Criteria andResidentialAreasLessThan(String value) {
            addCriterion("residential_areas <", value, "residentialAreas");
            return (Criteria) this;
        }

        public Criteria andResidentialAreasLessThanOrEqualTo(String value) {
            addCriterion("residential_areas <=", value, "residentialAreas");
            return (Criteria) this;
        }

        public Criteria andResidentialAreasLike(String value) {
            addCriterion("residential_areas like", value, "residentialAreas");
            return (Criteria) this;
        }

        public Criteria andResidentialAreasNotLike(String value) {
            addCriterion("residential_areas not like", value, "residentialAreas");
            return (Criteria) this;
        }

        public Criteria andResidentialAreasIn(List<String> values) {
            addCriterion("residential_areas in", values, "residentialAreas");
            return (Criteria) this;
        }

        public Criteria andResidentialAreasNotIn(List<String> values) {
            addCriterion("residential_areas not in", values, "residentialAreas");
            return (Criteria) this;
        }

        public Criteria andResidentialAreasBetween(String value1, String value2) {
            addCriterion("residential_areas between", value1, value2, "residentialAreas");
            return (Criteria) this;
        }

        public Criteria andResidentialAreasNotBetween(String value1, String value2) {
            addCriterion("residential_areas not between", value1, value2, "residentialAreas");
            return (Criteria) this;
        }

        public Criteria andResidentialNoteIsNull() {
            addCriterion("residential_note is null");
            return (Criteria) this;
        }

        public Criteria andResidentialNoteIsNotNull() {
            addCriterion("residential_note is not null");
            return (Criteria) this;
        }

        public Criteria andResidentialNoteEqualTo(String value) {
            addCriterion("residential_note =", value, "residentialNote");
            return (Criteria) this;
        }

        public Criteria andResidentialNoteNotEqualTo(String value) {
            addCriterion("residential_note <>", value, "residentialNote");
            return (Criteria) this;
        }

        public Criteria andResidentialNoteGreaterThan(String value) {
            addCriterion("residential_note >", value, "residentialNote");
            return (Criteria) this;
        }

        public Criteria andResidentialNoteGreaterThanOrEqualTo(String value) {
            addCriterion("residential_note >=", value, "residentialNote");
            return (Criteria) this;
        }

        public Criteria andResidentialNoteLessThan(String value) {
            addCriterion("residential_note <", value, "residentialNote");
            return (Criteria) this;
        }

        public Criteria andResidentialNoteLessThanOrEqualTo(String value) {
            addCriterion("residential_note <=", value, "residentialNote");
            return (Criteria) this;
        }

        public Criteria andResidentialNoteLike(String value) {
            addCriterion("residential_note like", value, "residentialNote");
            return (Criteria) this;
        }

        public Criteria andResidentialNoteNotLike(String value) {
            addCriterion("residential_note not like", value, "residentialNote");
            return (Criteria) this;
        }

        public Criteria andResidentialNoteIn(List<String> values) {
            addCriterion("residential_note in", values, "residentialNote");
            return (Criteria) this;
        }

        public Criteria andResidentialNoteNotIn(List<String> values) {
            addCriterion("residential_note not in", values, "residentialNote");
            return (Criteria) this;
        }

        public Criteria andResidentialNoteBetween(String value1, String value2) {
            addCriterion("residential_note between", value1, value2, "residentialNote");
            return (Criteria) this;
        }

        public Criteria andResidentialNoteNotBetween(String value1, String value2) {
            addCriterion("residential_note not between", value1, value2, "residentialNote");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNull() {
            addCriterion("district is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNotNull() {
            addCriterion("district is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictEqualTo(String value) {
            addCriterion("district =", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotEqualTo(String value) {
            addCriterion("district <>", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThan(String value) {
            addCriterion("district >", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("district >=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThan(String value) {
            addCriterion("district <", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThanOrEqualTo(String value) {
            addCriterion("district <=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLike(String value) {
            addCriterion("district like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotLike(String value) {
            addCriterion("district not like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictIn(List<String> values) {
            addCriterion("district in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotIn(List<String> values) {
            addCriterion("district not in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictBetween(String value1, String value2) {
            addCriterion("district between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotBetween(String value1, String value2) {
            addCriterion("district not between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andUserIsNull() {
            addCriterion("user is null");
            return (Criteria) this;
        }

        public Criteria andUserIsNotNull() {
            addCriterion("user is not null");
            return (Criteria) this;
        }

        public Criteria andUserEqualTo(String value) {
            addCriterion("user =", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotEqualTo(String value) {
            addCriterion("user <>", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThan(String value) {
            addCriterion("user >", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThanOrEqualTo(String value) {
            addCriterion("user >=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThan(String value) {
            addCriterion("user <", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThanOrEqualTo(String value) {
            addCriterion("user <=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLike(String value) {
            addCriterion("user like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotLike(String value) {
            addCriterion("user not like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserIn(List<String> values) {
            addCriterion("user in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotIn(List<String> values) {
            addCriterion("user not in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserBetween(String value1, String value2) {
            addCriterion("user between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotBetween(String value1, String value2) {
            addCriterion("user not between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(Integer value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(Integer value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(Integer value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(Integer value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(Integer value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<Integer> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<Integer> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(Integer value1, Integer value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("user_phone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("user_phone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("user_phone like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("user_phone not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("user_phone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("user_phone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("user_phone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Integer value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Integer value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Integer value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Integer value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Integer value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Integer> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Integer> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Integer value1, Integer value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andDotimeIsNull() {
            addCriterion("dotime is null");
            return (Criteria) this;
        }

        public Criteria andDotimeIsNotNull() {
            addCriterion("dotime is not null");
            return (Criteria) this;
        }

        public Criteria andDotimeEqualTo(String value) {
            addCriterion("dotime =", value, "dotime");
            return (Criteria) this;
        }

        public Criteria andDotimeNotEqualTo(String value) {
            addCriterion("dotime <>", value, "dotime");
            return (Criteria) this;
        }

        public Criteria andDotimeGreaterThan(String value) {
            addCriterion("dotime >", value, "dotime");
            return (Criteria) this;
        }

        public Criteria andDotimeGreaterThanOrEqualTo(String value) {
            addCriterion("dotime >=", value, "dotime");
            return (Criteria) this;
        }

        public Criteria andDotimeLessThan(String value) {
            addCriterion("dotime <", value, "dotime");
            return (Criteria) this;
        }

        public Criteria andDotimeLessThanOrEqualTo(String value) {
            addCriterion("dotime <=", value, "dotime");
            return (Criteria) this;
        }

        public Criteria andDotimeLike(String value) {
            addCriterion("dotime like", value, "dotime");
            return (Criteria) this;
        }

        public Criteria andDotimeNotLike(String value) {
            addCriterion("dotime not like", value, "dotime");
            return (Criteria) this;
        }

        public Criteria andDotimeIn(List<String> values) {
            addCriterion("dotime in", values, "dotime");
            return (Criteria) this;
        }

        public Criteria andDotimeNotIn(List<String> values) {
            addCriterion("dotime not in", values, "dotime");
            return (Criteria) this;
        }

        public Criteria andDotimeBetween(String value1, String value2) {
            addCriterion("dotime between", value1, value2, "dotime");
            return (Criteria) this;
        }

        public Criteria andDotimeNotBetween(String value1, String value2) {
            addCriterion("dotime not between", value1, value2, "dotime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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