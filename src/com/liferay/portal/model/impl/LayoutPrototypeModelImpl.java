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

package com.liferay.portal.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.LayoutPrototype;
import com.liferay.portal.model.LayoutPrototypeModel;
import com.liferay.portal.model.LayoutPrototypeSoap;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The base model implementation for the LayoutPrototype service. Represents a row in the &quot;LayoutPrototype&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portal.model.LayoutPrototypeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LayoutPrototypeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutPrototypeImpl
 * @see com.liferay.portal.model.LayoutPrototype
 * @see com.liferay.portal.model.LayoutPrototypeModel
 * @generated
 */
@JSON(strict = true)
public class LayoutPrototypeModelImpl extends BaseModelImpl<LayoutPrototype>
	implements LayoutPrototypeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a layout prototype model instance should use the {@link com.liferay.portal.model.LayoutPrototype} interface instead.
	 */
	public static final String TABLE_NAME = "LayoutPrototype";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "layoutPrototypeId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "settings_", Types.VARCHAR },
			{ "active_", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table LayoutPrototype (uuid_ VARCHAR(75) null,layoutPrototypeId LONG not null primary key,companyId LONG,name STRING null,description STRING null,settings_ STRING null,active_ BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table LayoutPrototype";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portal.model.LayoutPrototype"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portal.model.LayoutPrototype"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portal.model.LayoutPrototype"),
			true);
	public static long ACTIVE_COLUMN_BITMASK = 1L;
	public static long COMPANYID_COLUMN_BITMASK = 2L;
	public static long UUID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static LayoutPrototype toModel(LayoutPrototypeSoap soapModel) {
		LayoutPrototype model = new LayoutPrototypeImpl();

		model.setUuid(soapModel.getUuid());
		model.setLayoutPrototypeId(soapModel.getLayoutPrototypeId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setSettings(soapModel.getSettings());
		model.setActive(soapModel.getActive());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<LayoutPrototype> toModels(
		LayoutPrototypeSoap[] soapModels) {
		List<LayoutPrototype> models = new ArrayList<LayoutPrototype>(soapModels.length);

		for (LayoutPrototypeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portal.model.LayoutPrototype"));

	public LayoutPrototypeModelImpl() {
	}

	public long getPrimaryKey() {
		return _layoutPrototypeId;
	}

	public void setPrimaryKey(long primaryKey) {
		setLayoutPrototypeId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_layoutPrototypeId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return LayoutPrototype.class;
	}

	public String getModelClassName() {
		return LayoutPrototype.class.getName();
	}

	@JSON
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	public long getLayoutPrototypeId() {
		return _layoutPrototypeId;
	}

	public void setLayoutPrototypeId(long layoutPrototypeId) {
		_layoutPrototypeId = layoutPrototypeId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public String getName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId);
	}

	public String getName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId, useDefault);
	}

	public String getName(String languageId) {
		return LocalizationUtil.getLocalization(getName(), languageId);
	}

	public String getName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getName(), languageId,
			useDefault);
	}

	public String getNameCurrentLanguageId() {
		return _nameCurrentLanguageId;
	}

	@JSON
	public String getNameCurrentValue() {
		Locale locale = getLocale(_nameCurrentLanguageId);

		return getName(locale);
	}

	public Map<Locale, String> getNameMap() {
		return LocalizationUtil.getLocalizationMap(getName());
	}

	public void setName(String name) {
		_name = name;
	}

	public void setName(String name, Locale locale) {
		setName(name, locale, LocaleUtil.getDefault());
	}

	public void setName(String name, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(name)) {
			setName(LocalizationUtil.updateLocalization(getName(), "Name",
					name, languageId, defaultLanguageId));
		}
		else {
			setName(LocalizationUtil.removeLocalization(getName(), "Name",
					languageId));
		}
	}

	public void setNameCurrentLanguageId(String languageId) {
		_nameCurrentLanguageId = languageId;
	}

	public void setNameMap(Map<Locale, String> nameMap) {
		setNameMap(nameMap, LocaleUtil.getDefault());
	}

	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale) {
		if (nameMap == null) {
			return;
		}

		Locale[] locales = LanguageUtil.getAvailableLocales();

		for (Locale locale : locales) {
			String name = nameMap.get(locale);

			setName(name, locale, defaultLocale);
		}
	}

	@JSON
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	public String getSettings() {
		if (_settings == null) {
			return StringPool.BLANK;
		}
		else {
			return _settings;
		}
	}

	public void setSettings(String settings) {
		_settings = settings;
	}

	@JSON
	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_columnBitmask |= ACTIVE_COLUMN_BITMASK;

		if (!_setOriginalActive) {
			_setOriginalActive = true;

			_originalActive = _active;
		}

		_active = active;
	}

	public boolean getOriginalActive() {
		return _originalActive;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public LayoutPrototype toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (LayoutPrototype)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					LayoutPrototype.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		LayoutPrototypeImpl layoutPrototypeImpl = new LayoutPrototypeImpl();

		layoutPrototypeImpl.setUuid(getUuid());
		layoutPrototypeImpl.setLayoutPrototypeId(getLayoutPrototypeId());
		layoutPrototypeImpl.setCompanyId(getCompanyId());
		layoutPrototypeImpl.setName(getName());
		layoutPrototypeImpl.setDescription(getDescription());
		layoutPrototypeImpl.setSettings(getSettings());
		layoutPrototypeImpl.setActive(getActive());

		layoutPrototypeImpl.resetOriginalValues();

		return layoutPrototypeImpl;
	}

	public int compareTo(LayoutPrototype layoutPrototype) {
		long primaryKey = layoutPrototype.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LayoutPrototype layoutPrototype = null;

		try {
			layoutPrototype = (LayoutPrototype)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = layoutPrototype.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		LayoutPrototypeModelImpl layoutPrototypeModelImpl = this;

		layoutPrototypeModelImpl._originalUuid = layoutPrototypeModelImpl._uuid;

		layoutPrototypeModelImpl._originalCompanyId = layoutPrototypeModelImpl._companyId;

		layoutPrototypeModelImpl._setOriginalCompanyId = false;

		layoutPrototypeModelImpl._originalActive = layoutPrototypeModelImpl._active;

		layoutPrototypeModelImpl._setOriginalActive = false;

		layoutPrototypeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<LayoutPrototype> toCacheModel() {
		LayoutPrototypeCacheModel layoutPrototypeCacheModel = new LayoutPrototypeCacheModel();

		layoutPrototypeCacheModel.uuid = getUuid();

		String uuid = layoutPrototypeCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			layoutPrototypeCacheModel.uuid = null;
		}

		layoutPrototypeCacheModel.layoutPrototypeId = getLayoutPrototypeId();

		layoutPrototypeCacheModel.companyId = getCompanyId();

		layoutPrototypeCacheModel.name = getName();

		String name = layoutPrototypeCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			layoutPrototypeCacheModel.name = null;
		}

		layoutPrototypeCacheModel.description = getDescription();

		String description = layoutPrototypeCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			layoutPrototypeCacheModel.description = null;
		}

		layoutPrototypeCacheModel.settings = getSettings();

		String settings = layoutPrototypeCacheModel.settings;

		if ((settings != null) && (settings.length() == 0)) {
			layoutPrototypeCacheModel.settings = null;
		}

		layoutPrototypeCacheModel.active = getActive();

		return layoutPrototypeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", layoutPrototypeId=");
		sb.append(getLayoutPrototypeId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", settings=");
		sb.append(getSettings());
		sb.append(", active=");
		sb.append(getActive());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.model.LayoutPrototype");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>layoutPrototypeId</column-name><column-value><![CDATA[");
		sb.append(getLayoutPrototypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>settings</column-name><column-value><![CDATA[");
		sb.append(getSettings());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = LayoutPrototype.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			LayoutPrototype.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _layoutPrototypeId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private String _name;
	private String _nameCurrentLanguageId;
	private String _description;
	private String _settings;
	private boolean _active;
	private boolean _originalActive;
	private boolean _setOriginalActive;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private LayoutPrototype _escapedModelProxy;
}