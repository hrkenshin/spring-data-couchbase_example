package com.tony.examples.couchbase;

import com.couchbase.client.protocol.views.ComplexKey;
import com.couchbase.client.protocol.views.Query;
import com.tony.examples.couchbase.model.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional
public class EntityRepositoryTest {
    @Autowired
    private EntityRepository<UserInfo, String> userInfoRepository;

    @Test
    public void testSave() throws Exception {
        String uuid = UUID.randomUUID().toString();

        UserInfo userInfo = new UserInfo();
        userInfo.setUuid(uuid);
        userInfo.setType("user_info");
        userInfo.setUserid("TESTER");
        userInfo.setUsername("TESTER");
        userInfo.setCountrycode("KR");
        userInfo.setOs(1);
        userInfo.setRegdt(new Date());

        userInfoRepository.save(userInfo);

        UserInfo result = userInfoRepository.findOne(uuid);

        System.out.println(result);
    }

    /**
     * You need to create view ( _design/entity/all )
     * <p>
     * - map script
     * <pre>
     * function (doc, meta) {
     *     emit(null, null)
     * }
     * </pre>
     * <p>
     * - reduce script
     * <pre>
     * _count
     * </pre>
     *
     * @throws Exception
     */
    @Test
    public void testCount() throws Exception {
        System.out.println(userInfoRepository.count());
    }

    /**
     * You need to create view ( _design/entity/byType )
     * <p>
     * - map script
     * <pre>
     * function (doc, meta) {
     *     if(doc.type && doc.userid) {
     *         emit([doc.type, doc.userid], null);
     *     }
     * }
     * </pre>
     *
     * @throws Exception
     */
    @Test
    public void testFindByType() throws Exception {
        Query query = new Query();

        query.setRangeStart(ComplexKey.of("user_info"));
        List<UserInfo> result1 = userInfoRepository.findByType(query);
        System.out.println(result1);

        query.setKey(ComplexKey.of("user_info", "TESTER"));
        List<UserInfo> result2 = userInfoRepository.findByType(query);
        System.out.println(result2);
    }
}


