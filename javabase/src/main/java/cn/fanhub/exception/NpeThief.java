/**
 *    Copyright 2018 chengfan(fanhub.cn)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.fanhub.exception;

/**
 *
 * @author chengfan
 * @version $Id: NpeThief.java, v 0.1 2018年04月09日 下午4:20 chengfan Exp $
 */
public class NpeThief {
    public void callManyNPEInLoop() {
        for (int i = 0; i < 116000; i++) {
            try {
                ((Object)null).getClass();
            } catch (Exception e) {
                // This will switch from 2 to 0 (indicating our problem is happening)
                System.out.println(i + ": " + e.getStackTrace().length);
            }
        }
    }
    public static void main(String ... args) {
        NpeThief thief = new NpeThief();
        thief.callManyNPEInLoop();
    }
}