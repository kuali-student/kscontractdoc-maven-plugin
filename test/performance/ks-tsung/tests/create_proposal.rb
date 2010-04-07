#!/usr/bin/env ruby

#
# == Description
#
# Login as a member and create a proposal
#
# === Issues
#
# Jira 1234 - Fake jira issue

require File.dirname(__FILE__) + '/../lib/tsung-api.rb'
require File.dirname(__FILE__) + '/../lib/utility/authentication.rb'
require File.dirname(__FILE__) + '/../lib/curriculum/curriculum.rb'
require 'drb'

# Test info - default test case setup
test = File.basename(__FILE__)
config = DRbObject.new nil, "druby://localhost:#{ENV['DRB_PORT']}"
probability = config.tests[test]
config.log.info_msg("Test: #{test}")
config.log.info_msg("Probability: #{config.tests[test]}")

# Create session
sesh = Session.new(config, 'create_proposal', probability)

# Login is department COC
username = config.directory["department_coc"]["member"]["username"]
password = config.directory["department_coc"]["member"]["password"]

li_txn = sesh.add_transaction("login")
li_req = li_txn.add_requests
config.log.info_msg("#{test}: Logging in as department COC member: #{username}/#{password}")
auth = Authentication.new(li_req)
auth.login({:user => username, :password => password})

# Navigate to Curriculum Mgmt
nc_txn = sesh.add_transaction("nav_curriculum_mgmt")
nc_req = nc_txn.add_requests
config.log.info_msg("#{test}: Navigating to curriculum management")
Curriculum.new(nc_req).homepage

# Create blank proposal
cp_txn = sesh.add_transaction("create_proposal")
cp_req = cp_txn.add_requests
config.log.info_msg("#{test}: Creating proposal")
Curriculum.new(cp_req).create_proposal(
  "Performance Proposal 48", 
  config.directory["department"]["name"], 
  config.directory["department_coc"]["name"],
  username
)

# Logout
config.log.info_msg("#{test}: Logging out")
lo_txn = sesh.add_transaction("logout")
lo_req = lo_txn.add_requests
lo_auth = Authentication.new(lo_req)
lo_auth.logout