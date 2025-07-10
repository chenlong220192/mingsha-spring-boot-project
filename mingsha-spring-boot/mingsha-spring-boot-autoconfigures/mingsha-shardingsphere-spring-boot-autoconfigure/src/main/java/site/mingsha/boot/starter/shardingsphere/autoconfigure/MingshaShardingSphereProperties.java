package site.mingsha.boot.starter.shardingsphere.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Mingsha ShardingSphere 配置属性
 */
@ConfigurationProperties(prefix = "spring.shardingsphere")
public class MingshaShardingSphereProperties {
    /**
     * 是否启用ShardingSphere
     */
    private boolean enabled = true;
    
    /**
     * 模式类型
     */
    private String modeType = "Memory";
    
    /**
     * 数据源名称
     */
    private String[] dataSourceNames = {};
    
    /**
     * 分片规则配置
     */
    private String shardingRuleConfig;
    
    /**
     * 读写分离配置
     */
    private String readWriteSplittingRuleConfig;
    
    /**
     * 数据脱敏配置
     */
    private String dataMaskRuleConfig;
    
    /**
     * 加密配置
     */
    private String encryptRuleConfig;
    
    /**
     * 影子库配置
     */
    private String shadowRuleConfig;

    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
    public String getModeType() { return modeType; }
    public void setModeType(String modeType) { this.modeType = modeType; }
    public String[] getDataSourceNames() { return dataSourceNames; }
    public void setDataSourceNames(String[] dataSourceNames) { this.dataSourceNames = dataSourceNames; }
    public String getShardingRuleConfig() { return shardingRuleConfig; }
    public void setShardingRuleConfig(String shardingRuleConfig) { this.shardingRuleConfig = shardingRuleConfig; }
    public String getReadWriteSplittingRuleConfig() { return readWriteSplittingRuleConfig; }
    public void setReadWriteSplittingRuleConfig(String readWriteSplittingRuleConfig) { this.readWriteSplittingRuleConfig = readWriteSplittingRuleConfig; }
    public String getDataMaskRuleConfig() { return dataMaskRuleConfig; }
    public void setDataMaskRuleConfig(String dataMaskRuleConfig) { this.dataMaskRuleConfig = dataMaskRuleConfig; }
    public String getEncryptRuleConfig() { return encryptRuleConfig; }
    public void setEncryptRuleConfig(String encryptRuleConfig) { this.encryptRuleConfig = encryptRuleConfig; }
    public String getShadowRuleConfig() { return shadowRuleConfig; }
    public void setShadowRuleConfig(String shadowRuleConfig) { this.shadowRuleConfig = shadowRuleConfig; }
} 