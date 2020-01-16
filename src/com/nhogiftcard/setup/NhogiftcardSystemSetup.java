/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package com.nhogiftcard.setup;

import static com.nhogiftcard.constants.NhogiftcardConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.nhogiftcard.constants.NhogiftcardConstants;
import com.nhogiftcard.service.NhogiftcardService;


@SystemSetup(extension = NhogiftcardConstants.EXTENSIONNAME)
public class NhogiftcardSystemSetup
{
	private final NhogiftcardService nhogiftcardService;

	public NhogiftcardSystemSetup(final NhogiftcardService nhogiftcardService)
	{
		this.nhogiftcardService = nhogiftcardService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		nhogiftcardService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return NhogiftcardSystemSetup.class.getResourceAsStream("/nhogiftcard/sap-hybris-platform.png");
	}
}
