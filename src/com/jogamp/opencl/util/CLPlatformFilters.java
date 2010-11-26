/*
 * Copyright 2009 - 2010 JogAmp Community. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 * 
 *    1. Redistributions of source code must retain the above copyright notice, this list of
 *       conditions and the following disclaimer.
 * 
 *    2. Redistributions in binary form must reproduce the above copyright notice, this list
 *       of conditions and the following disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY JogAmp Community ``AS IS'' AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL JogAmp Community OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * The views and conclusions contained in the software and documentation are those of the
 * authors and should not be interpreted as representing official policies, either expressed
 * or implied, of JogAmp Community.
 */

package com.jogamp.opencl.util;

import com.jogamp.opencl.CLDevice;
import com.jogamp.opencl.CLPlatform;
import com.jogamp.opencl.CLVersion;
import java.util.Arrays;

/**
 * Pre-defined filters.
 * @author Michael Bien
 * @see CLPlatform#getDefault(com.jogamp.opencl.util.Filter[])
 * @see CLPlatform#listCLPlatforms(com.jogamp.opencl.util.Filter[]) 
 */
public class CLPlatformFilters {

    /**
     * Accepts all platforms supporting at least the given OpenCL spec version.
     */
    public static Filter<CLPlatform> version(final CLVersion version) {
        return new Filter<CLPlatform>() {
            public boolean accept(CLPlatform item) {
                return item.isAtLeast(version);
            }
        };
    }

    /**
     * Accepts all platforms containing devices of the given type.
     */
    public static Filter<CLPlatform> type(final CLDevice.Type type) {
        return new Filter<CLPlatform>() {
            public boolean accept(CLPlatform item) {
                return item.listCLDevices(type).length > 0;
            }
        };
    }

    /**
     * Accepts all platforms containing devices of the given extensions.
     */
    public static Filter<CLPlatform> extensions(final String... extensions) {
        return new Filter<CLPlatform>() {
            public boolean accept(CLPlatform item) {
                return item.getExtensions().containsAll(Arrays.asList(extensions));
            }
        };
    }
}
