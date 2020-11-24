package bdd.cicd;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",
					plugin = { "de.monochromata.cucumber.report.PrettyReports:target/cucumber"})
public class CucumberTest {

}