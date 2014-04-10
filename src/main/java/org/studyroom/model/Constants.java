package org.studyroom.model;/*
 * $Header: /cvsroot/securityfilter/securityfilter/src/example/org/securityfilter/example/org.studyroom.model.Constants.java,v 1.5 2004/01/26 10:55:37 maxcooper Exp $
 * $Revision: 1.5 $
 * $Date: 2004/01/26 10:55:37 $
 *
 * ====================================================================
 * The SecurityFilter Software License, Version 1.1
 *
 * (this license is derived and fully compatible with the Apache Software
 * License - see http://www.apache.org/LICENSE.txt)
 *
 * Copyright (c) 2002 SecurityFilter.org. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution,
 *    if any, must include the following acknowledgment:
 *       "This product includes software developed by
 *        SecurityFilter.org (http://www.securityfilter.org/)."
 *    Alternately, this acknowledgment may appear in the software itself,
 *    if and wherever such third-party acknowledgments normally appear.
 *
 * 4. The name "SecurityFilter" must not be used to endorse or promote
 *    products derived from this software without prior written permission.
 *    For written permission, please contact license@securityfilter.org .
 *
 * 5. Products derived from this software may not be called "SecurityFilter",
 *    nor may "SecurityFilter" appear in their name, without prior written
 *    permission of SecurityFilter.org.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE SECURITY FILTER PROJECT OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 */

/**
 * org.studyroom.model.Constants - constants for the example applications to facilitate testing
 *
 * @author Max Cooper (max@maxcooper.com)
 * @version $Revision: 1.5 $ $Date: 2004/01/26 10:55:37 $
 */
public interface Constants {

    // shared constants
    public static final String COMMON_TITLE_BASE = "StudyRoom";
    // home page constants
    public static final String HOME_TITLE = COMMON_TITLE_BASE + " Home";
    public static final String VALID_USERNAME = "user@example.com";
    public static final String VALID_PASSWORD = "password";
    public static final String LOGIN_FORM_ID = "loginForm";
    public static final String REGISTER_FORM_ID = "registerForm";
    public static final String LOGIN_FORM_ACTION = "j_security_check";
    public static final String LOGIN_USERNAME_FIELD = "j_username";
    public static final String LOGIN_PASSWORD_FIELD = "j_password";
    public static final String LOG_IN = "Log In";
    public static final String REGISTER = "Sign In";

}
