package cn.ltysyn.infiniti.common.algo;

public class SnowFlakeUtil {

	private final Long id;

	private final Long epoch = 1524291141010L;

	private Long sequence = 0L;

	/**
	 * 机器标识位数
	 */
	private final Long workerIdBits = 10L;
	
	/**
	 * 机器ID最大值: 1023
	 */
	private final Long maxWorkerId = -1L ^ -1L << this.workerIdBits;

	private final Long sequenceBits = 12L;

	private final Long sequenceMask = -1L ^ -1L << this.sequenceBits;

	/**
	 * 12
	 */
	private final Long workerIdShift = this.sequenceBits;
	
	/**
	 * 22
	 */
	private final Long timestampLeftShift = this.sequenceBits + this.workerIdBits;

	private Long lastTimestamp = -1L;
	
	private SnowFlakeUtil(long id) {
        if (id > this.maxWorkerId || id < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", this.maxWorkerId));
        }
        this.id = id;
    }

	public synchronized Long nextId() {
		long timestamp = timeGen();
		if (this.lastTimestamp == timestamp) {
			// 如果上一个timestamp与新产生的相等，则sequence加一(0-4095循环)
			// 对新的timestamp，sequence从0开始
			this.sequence = this.sequence + 1 & this.sequenceMask;
			if (this.sequence == 0) {
				// 重新生成 timeStamp
				timestamp = tilNextMills(this.lastTimestamp);
			}
			
		} else {
			this.sequence = 0L;
		}
		
		this.lastTimestamp = timestamp;
		return timestamp - this.epoch << this.timestampLeftShift | this.id << this.workerIdShift | this.sequence;
		
	}
	
	private static SnowFlakeUtil flowIdWorker = new SnowFlakeUtil(1L);
	
	public static SnowFlakeUtil getFlowIdInstance() {
		return flowIdWorker;
	}

	/**
	 * 等待下一个毫秒的到来，保证返回的毫秒数在参数 lastTimeStamp
	 * 
	 * @param lastTimestamp
	 * @return
	 */
	private static long tilNextMills(long lastTimestamp) {
		long timestamp = timeGen();
		while (timestamp < lastTimestamp) {
			timestamp = timeGen();
		}
		return timestamp;
	}

	/**
	 * 获取当期系统时间（毫秒级别）
	 * 
	 * @return
	 */
	private static long timeGen() {
		return System.currentTimeMillis();
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			SnowFlakeUtil snowFlakeUtil = SnowFlakeUtil.getFlowIdInstance();
			System.out.println(snowFlakeUtil.nextId());
		}
	}

}
