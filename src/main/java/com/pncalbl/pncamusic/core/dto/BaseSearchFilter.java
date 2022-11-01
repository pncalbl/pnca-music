package com.pncalbl.pncamusic.core.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pncalbl
 * @date 2022/11/1 21:57
 * @e-mail pncalbl@qq.com
 * @description
 **/

public abstract class BaseSearchFilter {
	@Min(value = 1, message = "page最小值为1")
	private Integer page = 1;

	@Min(value = 0, message = "page最小值为1")
	private Integer size = 10;

	private String direction = "desc";

	private List<String> sortBy = new ArrayList<>();

	public Pageable toPageable() {
		sortBy.add("createdTime");
		List<Sort.Order> orders = new ArrayList<>();
		for (String sort : sortBy) {
			orders.add(new Sort.Order(Sort.Direction.fromString(direction), sort));
		}
		return PageRequest.of(page - 1, size, Sort.by(orders));
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public List<String> getSortBy() {
		return sortBy;
	}

	public void setSortBy(List<String> sortBy) {
		this.sortBy = sortBy;
	}
}
