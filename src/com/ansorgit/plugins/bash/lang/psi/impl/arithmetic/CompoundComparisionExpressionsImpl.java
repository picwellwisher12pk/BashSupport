/*
 * Copyright (c) Joachim Ansorg, mail@ansorg-it.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ansorgit.plugins.bash.lang.psi.impl.arithmetic;

import com.ansorgit.plugins.bash.lang.lexer.BashTokenTypes;
import com.ansorgit.plugins.bash.lang.psi.api.arithmetic.CompoundComparision;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.IElementType;

/**
 * @author jansorg
 */
public class CompoundComparisionExpressionsImpl extends AbstractExpression implements CompoundComparision {
    public CompoundComparisionExpressionsImpl(final ASTNode astNode) {
        super(astNode, "Compound comparision", Type.TwoOperands);
    }

    @Override
    protected Long compute(long currentValue, IElementType operator, Long nextExpressionValue) {
        if (operator == BashTokenTypes.ARITH_LT) {
            return currentValue < nextExpressionValue ? 1L : 0L;
        } else if (operator == BashTokenTypes.ARITH_LE) {
            return currentValue <= nextExpressionValue ? 1L : 0L;
        } else if (operator == BashTokenTypes.ARITH_GT) {
            return currentValue > nextExpressionValue ? 1L : 0L;
        } else if (operator == BashTokenTypes.ARITH_GE) {
            return currentValue >= nextExpressionValue ? 1L : 0L;
        }

        return null;
    }
}