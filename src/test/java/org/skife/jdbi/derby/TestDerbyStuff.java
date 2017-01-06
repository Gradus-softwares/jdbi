/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.skife.jdbi.derby;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Statement;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TestDerbyStuff
{
    private final DerbyHelper derbyHelper = new DerbyHelper();

    @Test
    public void testNoExceptionOnCreationAndDeletion() throws Exception
    {
        try
        {
            derbyHelper.start();
            derbyHelper.stop();
        }
        catch (Exception e)
        {
            fail("Unable to create and delete test directory: " + e.getMessage());
        }
    }

    @Test
    public void testCreateSchema() throws Exception
    {
        derbyHelper.start();
        derbyHelper.dropAndCreateSomething();
        final Connection conn = derbyHelper.getConnection();

        final Statement stmt = conn.createStatement();
        assertTrue(stmt.execute("select count(*) from something"));

        stmt.close();
        conn.close();
        derbyHelper.stop();
    }
}
