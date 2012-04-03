/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.usergroupsadmin.search;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.usersadmin.util.UsersAdminUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

/**
 * @author Charles May
 */
public class UserGroupSearch extends SearchContainer<UserGroup> {

	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();

	static {
		headerNames.add("name");
		headerNames.add("description");

		orderableHeaders.put("name", "name");
		orderableHeaders.put("description", "description");
	}

	public static final String EMPTY_RESULTS_MESSAGE =
		"no-user-groups-were-found";

	public UserGroupSearch(
		PortletRequest portletRequest, PortletURL iteratorURL) {

		super(
			portletRequest, new UserGroupDisplayTerms(portletRequest),
			new UserGroupSearchTerms(portletRequest), DEFAULT_CUR_PARAM,
			DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		UserGroupDisplayTerms displayTerms =
			(UserGroupDisplayTerms)getDisplayTerms();

		iteratorURL.setParameter(
			UserGroupDisplayTerms.DESCRIPTION, displayTerms.getDescription());
		iteratorURL.setParameter(
			UserGroupDisplayTerms.NAME, displayTerms.getName());

		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(
					portletRequest);

			String orderByCol = ParamUtil.getString(
				portletRequest, "orderByCol");
			String orderByType = ParamUtil.getString(
				portletRequest, "orderByType");

			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(
					PortletKeys.USERS_ADMIN, "user-groups-order-by-col",
					orderByCol);
				preferences.setValue(
					PortletKeys.USERS_ADMIN, "user-groups-order-by-type",
					orderByType);
			}
			else {
				orderByCol = preferences.getValue(
					PortletKeys.USERS_ADMIN, "user-groups-order-by-col",
					"name");
				orderByType = preferences.getValue(
					PortletKeys.USERS_ADMIN, "user-groups-order-by-type",
					"asc");
			}

			OrderByComparator orderByComparator =
				UsersAdminUtil.getUserGroupOrderByComparator(
					orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(UserGroupSearch.class);

}