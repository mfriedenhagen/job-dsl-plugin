package javaposse.jobdsl.dsl.helpers.scm

import javaposse.jobdsl.dsl.Context

class GitBrowserContext implements Context {
    Node browser

    void stash(String url) {
        browser = NodeBuilder.newInstance().browser(class: 'hudson.plugins.git.browser.Stash') {
            delegate.url(url)
        }
    }

    void github(String url) {
        browser = NodeBuilder.newInstance().browser(class: 'hudson.plugins.git.browser.GithubWeb') {
            delegate.url(url)
        }
    }

    void gitweb(String url) {
        browser = NodeBuilder.newInstance().browser(class: 'hudson.plugins.git.browser.GitWeb') {
            delegate.url(url)
        }
    }

    void gitlab(String url, String version) {
        browser = NodeBuilder.newInstance().browser(class: 'hudson.plugins.git.browser.GitLab') {
            delegate.url(url)
            delegate.version(version)
        }
    }
}
