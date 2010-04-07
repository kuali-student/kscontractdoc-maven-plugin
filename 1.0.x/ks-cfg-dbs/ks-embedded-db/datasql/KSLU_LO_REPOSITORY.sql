TRUNCATE TABLE KSLU_LO_REPOSITORY DROP STORAGE
/
INSERT INTO KSLU_LO_REPOSITORY (EFF_DT,EXPIR_DT,ID,NAME,RT_DESCR_ID,VERSIONIND)
  VALUES (TO_DATE( '20080101000000', 'YYYYMMDDHH24MISS' ),TO_DATE( '20100101000000', 'YYYYMMDDHH24MISS' ),'kuali.loRepository.key.institution','Institution','RICHTEXT-18',1)
/
INSERT INTO KSLU_LO_REPOSITORY (EFF_DT,EXPIR_DT,ID,NAME,RT_DESCR_ID,VERSIONIND)
  VALUES (TO_DATE( '20080101000000', 'YYYYMMDDHH24MISS' ),TO_DATE( '20100101000000', 'YYYYMMDDHH24MISS' ),'kuali.loRepository.key.singleUse','singleUse','RICHTEXT-10',1)
/
INSERT INTO KSLU_LO_REPOSITORY (EFF_DT,EXPIR_DT,ID,NAME,RT_DESCR_ID,VERSIONIND)
  VALUES (TO_DATE( '20080101000000', 'YYYYMMDDHH24MISS' ),TO_DATE( '20100101000000', 'YYYYMMDDHH24MISS' ),'kuali.loRepository.key.state','State','RICHTEXT-22',1)
/