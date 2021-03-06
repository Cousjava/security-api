/*
 * Copyright (c) 2015, 2018 Oracle and/or its affiliates and others.
 * All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */
package javax.security.enterprise.authentication.mechanism.http;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.util.AnnotationLiteral;
import javax.interceptor.InterceptorBinding;

/**
 * The AutoApplySession annotation provides an application the ability to declaratively designate
 * that an authentication mechanism uses the <code>javax.servlet.http.registerSession</code>
 * and auto applies this for every request.
 *
 * <p>
 * See the JASPIC 1.1 specification section 3.8.4 for further details on <code>javax.servlet.http.registerSession</code>.
 *
 * <p>
 * This support is provided via an implementation of an interceptor spec interceptor that conducts the
 * necessary logic.
 *
 * <p>
 * Example:
 *
 * <pre>
 * <code>
 *     {@literal @}RequestScoped
 *     {@literal @}AutoApplySession
 *     public class CustomAuthenticationMechanism implements HttpAuthenticationMechanism {
 *         // ...
 *     }
 * </code>
 * </pre>
 *
 */
@Inherited
@InterceptorBinding
@Retention(RUNTIME)
@Target(TYPE)
public @interface AutoApplySession {

    /**
     * A default literal for the {@link AutoApplySession} annotation.
     *
     * @since 1.1
     */
    @SuppressWarnings("all")
    public final static class Literal extends AnnotationLiteral<AutoApplySession> implements AutoApplySession {

        private static final long serialVersionUID = 1L;

        public static final Literal INSTANCE = new Literal();

    }
}
