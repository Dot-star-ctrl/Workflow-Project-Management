require("dotenv").config();

module.exports = {
    src_folders: ["/tests"],
    page_objects_path: ["tests/pages"],

    test_workers: false,

    selenium: {
        start_process: false,
        // server_path: require('selenium-server').path,
        // selenium_host: "localhost",
        // selenium_port: 4444,
        cli_args: {
            "webdriver.chrome.driver": require('chromedriver').path
        }
    },

    webdriver: {
        start_process: false
    },

    test_settings: {
        default: {
            selenium_port: 4444,
            selenium_host: "${SELENIUM_HOST}",

            screenshots: {
                enabled: true,
                path: "tests_output/",
                on_failure: true
            },

            desiredCapabilities: {
                browserName: "chrome",
                chromeOptions: {
                    w3c: false,
                    args: [
                        // 'headless',
                        // 'disable-gpu',
                        '--no-sandbox'
                    ]
                }
            }
        }
    }
};
