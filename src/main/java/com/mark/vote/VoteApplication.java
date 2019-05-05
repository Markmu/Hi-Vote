package com.mark.vote;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class VoteApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(VoteApplication.class, args);
	}

	private void generateArtifacts() throws Exception {
		List<String> warnings = new ArrayList<String>();
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(this.getClass().getResourceAsStream("/generatorConfig.xml"));
		DefaultShellCallback callback = new DefaultShellCallback(true);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		generateArtifacts();
	}
}
